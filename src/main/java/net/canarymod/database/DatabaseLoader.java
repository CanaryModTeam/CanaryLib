package net.canarymod.database;

import net.canarymod.CanaryClassLoader;
import net.canarymod.database.exceptions.DatabaseException;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.UtilityException;

import java.io.File;
import java.net.MalformedURLException;

import static net.canarymod.Canary.log;

/**
 * Checks a database folder in CanaryMods root folder for
 * external Database Implementations and loads them
 *
 * @author Chris (damagefilter)
 */
public class DatabaseLoader {
    /**
     * Scans db adapters folder, loads all valid databases and registers them
     * at Database.Type. This must be the first bootstrapping step,
     * as all other steps require a functional database.
     * This also means this must not make use of anything that isn't loaded already
     */
    public static void load() {
        File dbFolder = new File("dbadapters/");
        if (!dbFolder.exists()) {
            dbFolder.mkdirs();
        }
        for (File file : dbFolder.listFiles()) {
            if (!file.getName().endsWith(".jar")) {
                continue;
            }
            try {
                PropertiesFile inf = new PropertiesFile(file.getAbsolutePath(), "Canary.inf");
                CanaryClassLoader ploader = new CanaryClassLoader(file.toURI().toURL(), DatabaseLoader.class.getClassLoader());
                String mainclass = inf.getString("main-class");
                String dbName = inf.getString("database-name");
                Class<?> dbClass = ploader.loadClass(mainclass);

                Database db = (Database)dbClass.newInstance();
                if (db != null) {
                    Database.Type.registerDatabase(dbName, db);
                }
            }
            catch (UtilityException e) {
                log.error("Could not find databases mainclass", e);
                return;
            }
            catch (ClassNotFoundException e) {
                log.error("Could not find databases mainclass", e);
            }
            catch (IllegalAccessException e) {
                log.error("Could not create database", e);
            }
            catch (DatabaseException e) {
                log.error("Could not add database", e);
            }
            catch (SecurityException e) {
                log.error(e.getMessage(), e);
            }
            catch (InstantiationException e) {
                log.error(e.getMessage(), e);
            }
            catch (MalformedURLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
