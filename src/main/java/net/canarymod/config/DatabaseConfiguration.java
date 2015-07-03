package net.canarymod.config;

import net.visualillusionsent.utils.PropertiesFile;

import java.io.File;

import static net.canarymod.Canary.log;

/**
 * Database Configuration settings
 *
 * @author Jos Kuijpers
 * @author Jason (darkdiplomat)
 */
public class DatabaseConfiguration implements ConfigurationContainer {
    private PropertiesFile cfg;

    public DatabaseConfiguration(String path) {
        File test = new File(path);

        if (!test.exists()) {
            log.info("Could not find the database configuration at " + path + ", creating default.");
        }
        this.cfg = new PropertiesFile(path);
        verifyConfig();
    }

    /**
     * Reloads the configuration file
     */
    @Override
    public void reload() {
        cfg.reload();
        verifyConfig();
    }

    /**
     * Get the configuration file
     */
    @Override
    public PropertiesFile getFile() {
        return cfg;
    }

    /**
     * Creates the default configuration
     */
    private void verifyConfig() {
        cfg.clearHeader();
        cfg.addHeaderLines(
                "For more settings explanations see following websites ...",
                "http://javatech.org/2007/11/c3p0-connectionpool-configuration-rules-of-thumb/",
                "https://community.jboss.org/wiki/HowToConfigureTheC3P0ConnectionPool?_sscc=t"
                          );

        cfg.getString("name", "canarymod");
        cfg.getString("host", "localhost");
        cfg.getString("username", "admin");
        cfg.getString("password", "admin");
        cfg.getInt("port", 3306);
        cfg.getInt("maxConnections", 5);

        // c3p0 settings

        cfg.getInt("acquire-increment", 5);
        cfg.setComments("acquire-increment", "Determines how many connections at a time c3p0 will try to acquire when the pool is exhausted.");

        cfg.getInt("max-connection-idle-time", 900); //15 minutes
        cfg.setComments("max-connection-idle-time", "Determines how long idle connections can stay in the connection pool before they are removed.");

        cfg.getInt("max-excess-connections-idle-time", 1800); // 30 minutes
        cfg.setComments("max-excess-connections-idle-time", "Time until the connection pool will be culled down to min-connection-pool-size. Set 0 to not enforce pool shrinking.");

        cfg.getInt("max-connection-pool-size", 10);
        cfg.setComments("max-connection-pool-size", "The maximum allowed number of pooled connections. More for larger servers");

        cfg.getInt("min-connection-pool-size", 3);
        cfg.setComments("min-connection-pool-size", "The minimum amount of connections allowed. More means more memory usage but takes away some impact from creating new connections.");

        cfg.getInt("num-helper-threads", 4);
        cfg.setComments("num-helper-threads", "Amount of threads that will perform slow JDBC operations (closing idle connections, returning connections to pool etc)");

        cfg.getInt("return-connection-timeout", 900); //15 minutes
        cfg.setComments("return-connection-timeout", "Defines a time a connection can remain checked out. After that it will be forced back into the connection pool.");

        cfg.getInt("connection-test-frequency", 0); // 60 minutes
        cfg.setComments("idle-connection-test-frequency", "Every this amount of seconds idle connections will be checked for validity. Set 0 to turn off");

        cfg.getInt("max-cached-statements", 50);
        cfg.setComments("max-cached-statements", "Number of max cached statements on all connections. (Roughly 5 * expected pooled connections)");

        cfg.getInt("max-statements-per-connection", 5);
        cfg.setComments("max-statements-per-connection", "Number of max cached statements on a single connection.");

        cfg.getInt("statement-cache-close-threads", 1);
        cfg.setComments("statement-cache-close-threads", "Number of threads to use when closing statements is deferred (happens when parent connection is still in use)");

        // Table Naming Schemes...
        cfg.getString("bans-table-name", "ban");
        cfg.setComments("bans-table-name", "The name to use for the Bans table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("groups-table-name", "group");
        cfg.setComments("groups-table-name", "The name to use for the Groups table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("kits-table-name", "kit");
        cfg.setComments("kits-table-name", "The name to use for the Kits table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("operators-table-name", "operators");
        cfg.setComments("operators-table-name", "The name to use for the Operators table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("permissions-table-name", "permission");
        cfg.setComments("permissions-table-name", "The name to use for the Permissions table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("players-table-name", "player");
        cfg.setComments("players-table-name", "The name to use for the Permissions table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("reservelist-table-name", "reservelist");
        cfg.setComments("reservelist-table-name", "The name to use for the ReserveList table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("warps-table-name", "warp");
        cfg.setComments("warps-table-name", "The name to use for the Warps table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");

        cfg.getString("whitelist-table-name", "whitelist");
        cfg.setComments("whitelist-table-name", "The name to use for the WhiteList table. NOTE: Changing this here will require you to manually change the name of the table in the database (if present)");
        //

        cfg.save();
    }

    /**
     * Get the URL to the database.
     * This is a combination of host, port and database
     *
     * @param driver
     *         the JDBC driver name (ie: mysql or sqlite)
     *
     * @return database url
     */
    public String getDatabaseUrl(String driver) {
        int port = getDatabasePort();
        return "jdbc:" + driver + "://" + getDatabaseHost() + ((port == 0) ? "" : (":" + port)) + "/" + getDatabaseName();
    }

    /**
     * Get the database host, defaulting to localhost
     *
     * @return database host
     */
    public String getDatabaseHost() {
        return cfg.getString("host", "localhost");
    }

    /**
     * Get the database port
     *
     * @return The configured port or 0
     */
    public int getDatabasePort() {
        return cfg.getInt("port", 0);
    }

    /**
     * Get the name of the database. Defaults to 'canarymod'
     *
     * @return database name
     */
    public String getDatabaseName() {
        return cfg.getString("name", "canarymod");
    }

    /**
     * Get database user
     * This might be null if the datasource is not a password protected database type such as XML.
     *
     * @return database username
     */
    public String getDatabaseUser() {
        return cfg.getString("username");
    }

    /**
     * Get database password.
     * This might be null if the datasource is not a password protected database type such as XML.
     *
     * @return database password
     */
    public String getDatabasePassword() {
        return cfg.getString("password");
    }

    /**
     * Get the maximum number of concurrent connections to the database.
     * This might be null if the datasource is not a connection oriented database type such as XML.
     *
     * @return database maximum connections
     */
    public int getDatabaseMaxConnections() {
        return cfg.getInt("maxConnections");
    }

    /**
     * Defines the total number PreparedStatements a DataSource will cache.
     * The pool will destroy the least-recently-used PreparedStatement when it hits this limit.
     *
     * @return config for max cached statements
     */
    public int getMaxCachedStatements() {
        return cfg.getInt("max-cached-statements", 50);
    }

    /**
     * Defines how many statements each pooled Connection is allowed to own.
     * You can set this to a bit more than the number of PreparedStatements
     * your application frequently uses, to avoid churning.
     *
     * @return config for max num of pooled statements per connection
     */
    public int getMaxCachedStatementsPerConnection() {
        return cfg.getInt("max-statements-per-connection", 5);
    }

    /**
     * If greater than zero, the Statement pool will defer physically close()ing cached Statements
     * until its parent Connection is not in use by any client or internally (in e.g. a test) by the pool itself.
     *
     * @return config num of threads used to defer closing statements
     */
    public int getNumStatementCloseThreads() {
        return cfg.getInt("statement-cache-close-threads", 1);
    }

    /**
     * Defines the interval of checking validity of pooled connections in seconds.
     *
     * @return connection re-check interval
     */
    public int getConnectionTestFrequency() {
        return cfg.getInt("connection-test-frequency", 3600);
    }

    /**
     * Defines the time in seconds a connection can stay checked out, before it is returned to the connection pool.
     *
     * @return num of seconds a connection can stay checked out
     */
    public int getReturnConnectionTimeout() {
        return cfg.getInt("return-connection-timeout", 900);
    }

    /**
     * Defines the amount of threads to use when executing slow JDBC operations,
     * such as closing connections and statements.
     *
     * @return num of threads to use for heavy JDBC operations
     */
    public int getNumHelperThreads() {
        return cfg.getInt("num-helper-threads", 4);
    }

    /**
     * Defines the minimum amount of connections to keep alive in the connection pool.
     *
     * @return min amount of connections
     */
    public int getMinPoolSize() {
        return cfg.getInt("min-connection-pool-size", 3);
    }

    /**
     * Defines the maximum allowed number of connections in the connection pool.
     *
     * @return max allowed connections in pool
     */
    public int getMaxPoolSize() {
        return cfg.getInt("max-connection-pool-size", 10);
    }

    /**
     * Number of seconds that Connections in excess of minPoolSize
     * should be permitted to remain idle in the pool before being culled.
     * Set 0 to turn off culling
     *
     * @return seconds to keep excess connections
     */
    public int getMaxExcessConnectionsIdleTime() {
        return cfg.getInt("max-excess-connections-idle-time", 1800);
    }

    /**
     * Determines how many connections at a time to acquire when the pool is exhausted.
     *
     * @return connections to acquire
     */
    public int getAcquireIncrement() {
        return cfg.getInt("acquire-increment", 5);
    }

    /**
     * Time to keep idle connections in the pool before they are closed and discarded.
     *
     * @return keep-alive time of connections in pool
     */
    public int getMaxConnectionIdleTime() {
        return cfg.getInt("max-connection-idle-time", 900);
    }

    public String getBansTableName() {
        return cfg.getString("bans-table-name", "ban");
    }

    public String getGroupsTableName() {
        return cfg.getString("groups-table-name", "group");
    }

    public String getKitsTableName() {
        return cfg.getString("kits-table-name", "kit");
    }

    public String getOpertatorsTableName() {
        return cfg.getString("operators-table-name", "operators");
    }

    public String getPermissionsTableName() {
        return cfg.getString("permissions-table-name", "permission");
    }

    public String getPlayersTableName() {
        return cfg.getString("players-table-name", "player");
    }

    public String getReservelistTableName() {
        return cfg.getString("reservelist-table-name", "reservelist");
    }

    public String getWarpsTableName() {
        return cfg.getString("warps-table-name", "warp");
    }

    public String getWhitelistTableName() {
        return cfg.getString("whitelist-table-name", "whitelist");
    }
}
