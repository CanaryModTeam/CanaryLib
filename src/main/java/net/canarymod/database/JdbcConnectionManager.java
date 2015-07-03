package net.canarymod.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.canarymod.config.Configuration;
import net.canarymod.config.DatabaseConfiguration;
import net.canarymod.database.exceptions.DatabaseAccessException;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static net.canarymod.Canary.log;

/**
 * Represents a connection (pool) manager for all sorts of JDBC connections.
 * In our particular case that is mysql and sqlite.
 * For sqlite, due to the minimal nature of it,
 * there need to be a separate handling.
 * TODO: Configure statement caching!
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 */
public class JdbcConnectionManager {

    private ComboPooledDataSource cpds; // The data source pool ;)
    private Connection nonManaged; // For those that bypass the manager/unable to use the manager
    private SQLType type;

    private static JdbcConnectionManager instance;

    /**
     * Instantiates the connection manager
     *
     * @param type
     *         the database type
     *
     * @throws SQLException
     */
    private JdbcConnectionManager(SQLType type) throws SQLException {
        DatabaseConfiguration cfg = Configuration.getDbConfig();
        cpds = new ComboPooledDataSource();
        this.type = type;
        if (type.usesJDBCManager()) {
            try {
                cpds.setDriverClass(type.getClassPath());
                cpds.setJdbcUrl(cfg.getDatabaseUrl(type.getIdentifier()));
                cpds.setUser(cfg.getDatabaseUser());
                cpds.setPassword(cfg.getDatabasePassword());

                // For settings explanations see
                // http://javatech.org/2007/11/c3p0-connectionpool-configuration-rules-of-thumb/
                // https://community.jboss.org/wiki/HowToConfigureTheC3P0ConnectionPool?_sscc=t

                //connection pooling
                cpds.setAcquireIncrement(cfg.getAcquireIncrement());
                cpds.setMaxIdleTime(cfg.getMaxConnectionIdleTime());
                cpds.setMaxIdleTimeExcessConnections(cfg.getMaxExcessConnectionsIdleTime());
                cpds.setMaxPoolSize(cfg.getMaxPoolSize());
                cpds.setMinPoolSize(cfg.getMinPoolSize());
                cpds.setNumHelperThreads(cfg.getNumHelperThreads());
                cpds.setUnreturnedConnectionTimeout(cfg.getReturnConnectionTimeout());
                cpds.setIdleConnectionTestPeriod(cfg.getConnectionTestFrequency());

                //Statement pooling
                cpds.setMaxStatements(cfg.getMaxCachedStatements());
                cpds.setMaxStatementsPerConnection(cfg.getMaxCachedStatementsPerConnection());
                cpds.setStatementCacheNumDeferredCloseThreads(cfg.getNumStatementCloseThreads());
            }
            catch (PropertyVetoException e) {
                log.error("Failed to configure the connection pool!", e);
            }
            //Test connection...
            //If this fails it throws an SQLException so we're notified
            Connection c = cpds.getConnection();
            c.close();
        }
        else {
            nonManaged = DriverManager.getConnection(cfg.getDatabaseUrl(type.getIdentifier()), cfg.getDatabaseUser(), cfg.getDatabasePassword());
            nonManaged.close();
        }
    }

    /**
     * Get the SQL Database type.
     *
     * @return the type
     */
    public SQLType getType() {
        return this.type;
    }

    /**
     * Create a new instance of this connection manager.
     *
     * @return an instance of the manager
     *
     * @throws DatabaseAccessException
     */
    private static JdbcConnectionManager getInstance() throws DatabaseAccessException {
        if (instance == null) {
            try {
                SQLType type = SQLType.forName(Configuration.getServerConfig().getDatasourceType());
                if (type == null) {
                    throw new DatabaseAccessException(Configuration.getServerConfig().getDatasourceType() + " is not a valid JDBC Database type or has not been registered for use.");
                }
                instance = new JdbcConnectionManager(type);
            }
            catch (SQLException e) {
                throw new DatabaseAccessException("Unable to instantiate Connection Pool!", e);
            }
        }
        return instance;
    }

    /**
     * Get a connection form the connection pool.
     *
     * @return connection from the pool
     */
    public static Connection getConnection() {
        try {
            JdbcConnectionManager cman = getInstance();
            if (!cman.type.usesJDBCManager()) {
                if (cman.nonManaged != null) {
                    if (!cman.nonManaged.isClosed()) {
                        return cman.nonManaged;
                    }
                }
                DatabaseConfiguration cfg = Configuration.getDbConfig();
                cman.nonManaged = DriverManager.getConnection(cfg.getDatabaseUrl(cman.type.getIdentifier()), cfg.getDatabaseUser(), cfg.getDatabasePassword());
                return cman.nonManaged;
            }
            return cman.cpds.getConnection();
        }
        catch (SQLException e) {
            log.error("Couldn't get a Connection from pool!", e);
            return null;
        }
        catch (DatabaseAccessException e) {
            log.error("Couldn't get a Connection from pool!", e);
            return null;
        }
    }

    /**
     * Shut down the connection pool.
     * Should be called when the system is reloaded or goes down to prevent data loss.
     */
    public static void shutdown() {
        if (instance == null) {
            // already shut down or never instantiated (perhaps because we're running on a non-jdbc database)
            return;
        }
        instance.cpds.close();
        if (instance.nonManaged != null) {
            try {
                instance.nonManaged.close();
            }
            catch (SQLException e) {
                log.warn("Non-Managed connection could not be closed. Whoops!", e);
            }
        }
        instance = null;
    }
}
