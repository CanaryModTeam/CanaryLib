package net.canarymod.database;

import static net.canarymod.Canary.log;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.canarymod.config.Configuration;
import net.canarymod.config.DatabaseConfiguration;
import net.canarymod.database.exceptions.DatabaseAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Represents a connection (pool) manager for all sorts of JDBC connections.
 * In our particular case that is mysql and sqlite.
 * For sqlite, due to the minimal nature of it,
 * there need to be a separate handling.
 * TODO: Configure statement caching!
 *
 * @author Chris Ksoll (damagefilter)
 * @author Jason Jones (darkdiplomat)
 * @author Jamie Mansfield (jamierocks)
 */
public class JdbcConnectionManager {

    private HikariDataSource dataSource; // The data source pool ;)
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
        this.type = type;
        if (type.usesJDBCManager()) {
            final HikariConfig config = new HikariConfig();

            // Configure HikariConfig
            {
                config.setDriverClassName(type.getClassPath());
                config.setJdbcUrl(cfg.getDatabaseUrl(type.getIdentifier()));
                config.setUsername(cfg.getDatabaseUser());
                config.setPassword(cfg.getDatabasePassword());

                // getAcquireIncrement
                config.setIdleTimeout(cfg.getMaxConnectionIdleTime());
                // getMaxExcessConnectionsIdleTime
                config.setMaximumPoolSize(cfg.getMaxPoolSize());
                // getMinPoolSize
                // getNumHelperThreads
                // getReturnConnectionTimeout
                // getConnectionTestFrequency

                // getMaxCachedStatements
                // getMaxCachedStatementsPerConnection
                // getNumStatementCloseThreads
            }

            // Create the HikariDataSource
            this.dataSource = new HikariDataSource(config);

            // Test connection
            {
                try (final Connection c = this.dataSource.getConnection()) {
                    // noop
                }
                catch (final SQLException ex) {
                    throw new RuntimeException("Failed to test the connection!", ex);
                }
            }
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
            return cman.dataSource.getConnection();
        }
        catch (SQLException | DatabaseAccessException e) {
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
        instance.dataSource.close();
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
