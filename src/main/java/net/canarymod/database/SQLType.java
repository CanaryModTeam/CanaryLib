package net.canarymod.database;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Helper class so we can easily identify the driver type further down the code
 *
 * @author Jason Jones (darkdiplomat)
 * @author Chris Ksoll (damagefilter)
 */
public final class SQLType {
    private static final HashMap<DriverContainer, SQLType> driverRegistry = Maps.newHashMap();
    private final DriverContainer container;

    private SQLType(DriverContainer container) {
        this.container = container;
    }

    private static class DriverContainer {
        public final String classpath;
        public final String identifier;
        public final boolean useJDBCManager;

        private DriverContainer(String identifier, String classpath, boolean useJDBCManager) {
            this.classpath = classpath;
            this.identifier = identifier;
            this.useJDBCManager = useJDBCManager;
        }

        public final boolean equals(Object obj) {
            return obj instanceof DriverContainer &&
                    ((DriverContainer)obj).classpath.equals(this.classpath) &&
                    ((DriverContainer)obj).identifier.equals(this.identifier) &&
                    ((DriverContainer)obj).useJDBCManager == this.useJDBCManager;
        }
    }

    public String getClassPath() {
        return this.container.classpath;
    }

    public String getIdentifier() {
        return this.container.identifier;
    }

    public boolean usesJDBCManager() {
        return this.container.useJDBCManager;
    }

    public static SQLType forName(String name) {
        for (SQLType t : driverRegistry.values()) {
            if (t.getIdentifier().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public static SQLType registerSQLDriver(String identifier, String classpath) {
        return registerSQLDriver(identifier, classpath, true);
    }

    public static SQLType registerSQLDriver(String identifier, String classpath, boolean useJDBCManager) {
        DriverContainer temp = new DriverContainer(identifier, classpath, useJDBCManager);
        if (!driverRegistry.containsKey(temp)) {
            SQLType newType = new SQLType(temp);
            driverRegistry.put(temp, newType);
            return newType;
        }
        return null;
    }

    static {
        registerSQLDriver("sqlite", "org.sqlite.JDBC", false);
    }
}