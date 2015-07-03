package net.canarymod.database;

import net.canarymod.config.Configuration;
import net.canarymod.database.exceptions.DatabaseException;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.canarymod.database.mysql.MySQLDatabase;
import net.canarymod.database.sqlite.SQLiteDatabase;
import net.canarymod.database.xml.XmlDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.canarymod.Canary.log;

/**
 * A database representation, used to store any kind of data
 *
 * @author Chris (damagefilter)
 */
public abstract class Database {

    /**
     * The datasource type
     *
     * @author chris
     */
    public static class Type {
        private static HashMap<String, Database> registeredDatabases = new HashMap<String, Database>();

        public static void registerDatabase(String name, Database db) throws DatabaseException {
            if (registeredDatabases.containsKey(name)) {
                throw new DatabaseException(name + " cannot be registered. Type already exists");
            }
            registeredDatabases.put(name, db);
            log.info(String.format("Registered %s Database", name));
        }

        public static Database getDatabaseFromType(String name) {
            return registeredDatabases.get(name);
        }

        static {
            try {
                String dbname = Configuration.getServerConfig().getDatasourceType();
                if ("xml".equalsIgnoreCase(dbname)) {
                    Database.Type.registerDatabase("xml", XmlDatabase.getInstance());
                }
                else if ("mysql".equalsIgnoreCase(dbname)) {
                    Database.Type.registerDatabase("mysql", MySQLDatabase.getInstance());
                }
                else if ("sqlite".equalsIgnoreCase(dbname)) {
                    Database.Type.registerDatabase("sqlite", SQLiteDatabase.getInstance());
                }
            }
            catch (Exception e) {
                log.error("Exception occurred while trying to prepare databases!", e);
            }
        }
    }

    public static Database get() {
        Database ret = Database.Type.getDatabaseFromType(Configuration.getServerConfig().getDatasourceType());
        if (ret != null) {
            return ret;
        }
        else {
            log.warn("Database type " + Configuration.getServerConfig().getDatasourceType() + " is not available, falling back to XML! Fix your server.cfg");
            return XmlDatabase.getInstance();
        }
    }

    /**
     * Insert the given DataAccess object as new set of data into database
     *
     * @param data
     *         the data to insert
     *
     * @throws DatabaseWriteException
     *         when something went wrong during the write operation
     */
    public abstract void insert(DataAccess data) throws DatabaseWriteException;

    /**
     * Insert a range of DataAccess objects at once.
     *
     * @param data
     *         the list of data to insert
     *
     * @throws DatabaseWriteException
     *         when something went wrong during the write operation
     */
    public abstract void insertAll(List<DataAccess> data) throws DatabaseWriteException;

    /**
     * Updates the record in the database that fits to your fields and values given.
     * Those are NOT the values and fields to update. Those are values and fields to identify
     * the correct entry in the database to update. The updated data must be provided in the DataAccess
     *
     * @param data
     *         the data to be updated. Additionally this acts as information about the table schema
     * @param filters
     *         FieldName->Value map to filter which rows should be updated
     *
     * @throws DatabaseWriteException
     */
    public abstract void update(DataAccess data, Map<String, Object> filters) throws DatabaseWriteException;

    /**
     * Updates the records in the database that fits to your fields and values given.
     * Those are NOT the values and fields to update. Those are values and fields to identify
     * the correct entry in the database to update. The updated data must be provided in the DataAccess
     *
     * @param template
     *         the template data access used for verification.
     * @param data
     *         a map of data access objects to insert and the filters to apply them with
     *
     * @throws DatabaseWriteException
     */
    public abstract void updateAll(DataAccess template, Map<DataAccess, Map<String, Object>> data) throws DatabaseWriteException;

    /**
     * Removes the data set from the given table that suits the given field names and values.
     *
     * @param da
     *         the DataAccess object that specifies the data that should be removed
     * @param filters
     *         FieldName->Value map to filter which rows should be deleted
     *
     * @throws DatabaseWriteException
     */
    public abstract void remove(DataAccess da, Map<String, Object> filters) throws DatabaseWriteException;

    /**
     * Removes the data set from the given table that suits the given field names and values.
     *
     * @param da
     *         the DataAccess object that specifies the data that should be removed
     * @param filters
     *         FieldName->Value map to filter which rows should be deleted
     *
     * @throws DatabaseWriteException
     */
    public abstract void removeAll(DataAccess da, Map<String, Object> filters) throws DatabaseWriteException;

    /**
     * This method will fill your DataAccess object with the first data set from database,
     * that matches the given values in the given fields.<br>
     * For instance if you pass String[] {"score", "name"}<br>
     * with respective values Object[] {130, "damagefilter"},<br>
     * Canary will look in the database for records where score=130 and name=damagefilter.<br>
     * Canary will only look in the table with the name you have set in your AccessObject<br>
     *
     * @param dataset
     *         The class of your DataAccess object
     * @param filters
     *         FieldName->Value map to filter which row should be loaded
     *
     * @throws DatabaseReadException
     */
    public abstract void load(DataAccess dataset, Map<String, Object> filters) throws DatabaseReadException;

    /**
     * Loads all results that match the field - values given into a DataAccess list.
     *
     * @param typeTemplate
     *         The type template (an instance of the dataaccess type you want to load)
     * @param datasets
     *         DataAccess set - you can savely cast those to the type of typeTemplate
     * @param filters
     *         FieldName->Value map to filter which rows should be loaded
     *
     * @throws DatabaseReadException
     */
    public abstract void loadAll(DataAccess typeTemplate, List<DataAccess> datasets, Map<String, Object> filters) throws DatabaseReadException;

    /**
     * Updates the database table fields for the given DataAccess object.
     * This method will remove fields that aren't there anymore and add new ones if applicable.
     *
     * @param schemaTemplate
     *         the new schema
     */
    public abstract void updateSchema(DataAccess schemaTemplate) throws DatabaseWriteException;
}
