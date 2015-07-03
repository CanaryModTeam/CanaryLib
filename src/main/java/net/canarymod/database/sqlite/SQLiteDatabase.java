package net.canarymod.database.sqlite;

import net.canarymod.Canary;
import net.canarymod.database.Column;
import net.canarymod.database.Column.DataType;
import net.canarymod.database.DataAccess;
import net.canarymod.database.Database;
import net.canarymod.database.JdbcConnectionManager;
import net.canarymod.database.exceptions.DatabaseAccessException;
import net.canarymod.database.exceptions.DatabaseReadException;
import net.canarymod.database.exceptions.DatabaseTableInconsistencyException;
import net.canarymod.database.exceptions.DatabaseWriteException;
import net.visualillusionsent.utils.StringUtils;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static net.canarymod.Canary.log;

/**
 * SQLite Database
 *
 * @author Jason (darkdiplomat)
 */
public class SQLiteDatabase extends Database {

    private static SQLiteDatabase instance;
    private final String LIST_REGEX = "\u00B6";
    private final String NULL_STRING = "NULL";

    private SQLiteDatabase() {
        File path = new File("db/");

        if (!path.exists()) {
            path.mkdirs();
        }
        try {
            PreparedStatement ps = JdbcConnectionManager.getConnection().prepareStatement("PRAGMA encoding = \"UTF-8\"");
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            log.error("Error while instantiating a new SQLiteDatabase!", e);
        }
    }

    public static SQLiteDatabase getInstance() {
        if (SQLiteDatabase.instance == null) {
            SQLiteDatabase.instance = new SQLiteDatabase();
        }
        return SQLiteDatabase.instance;
    }

    @Override
    public void insert(DataAccess data) throws DatabaseWriteException {
        if (doesEntryExist(data)) {
            return;
        }
        PreparedStatement ps = null;

        try {
            HashMap<Column, Object> columns = data.toDatabaseEntryList();
            ps = JdbcConnectionManager.getConnection().prepareStatement(generateQuery(data));

            int i = 1;
            for (Column c : columns.keySet()) {
                if (!c.autoIncrement()) {
                    if (c.isList()) {
                        ps.setString(i, getString((List<?>)columns.get(c)));
                    }
                    ps.setObject(i, columns.get(c));
                    i++;
                }
            }

            if (ps.executeUpdate() == 0) {
                throw new DatabaseWriteException("Error inserting SQLite: no rows updated!");
            }
        }
        catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        catch (DatabaseTableInconsistencyException dtie) {
            log.error(dtie.getMessage(), dtie);
        }
        finally {
            close(null, ps, null);
        }
    }

    @Override
    public void insertAll(List<DataAccess> data) throws DatabaseWriteException {
        for (DataAccess da : data) {
            insert(da);
        }
    }

    @Override
    public void update(DataAccess data, Map<String, Object> filters) throws DatabaseWriteException {
        if (!doesEntryExist(data)) {
            return;
        }
        Connection conn = JdbcConnectionManager.getConnection();
        ResultSet rs = null;

        try {
            rs = this.getResultSet(conn, data, filters, true);
            if (rs != null) {
                if (rs.next()) {
                    HashMap<Column, Object> columns = data.toDatabaseEntryList();
                    Iterator<Column> it = columns.keySet().iterator();
                    Column column;
                    while (it.hasNext()) {
                        column = it.next();
                        if (column.isList()) {
                            rs.updateObject(column.columnName(), this.getString((List<?>)columns.get(column)));
                        }
                        else {
                            rs.updateObject(column.columnName(), columns.get(column));
                        }
                    }
                    rs.updateRow();
                }
                else {
                    throw new DatabaseWriteException("Error updating DataAccess to SQLite, no such entry: " + data.toString());
                }
            }
        }
        catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        catch (DatabaseTableInconsistencyException dtie) {
            log.error(dtie.getMessage(), dtie);
        }
        catch (DatabaseReadException e) {
            log.error(e.getMessage(), e);
        }
        finally {
            PreparedStatement st = null;
            try {
                st = rs != null && rs.getStatement() instanceof PreparedStatement ? (PreparedStatement)rs.getStatement() : null;
            }
            catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
            close(conn, st, rs);
        }
    }

    @Override
    public void updateAll(DataAccess template, Map<DataAccess, Map<String, Object>> list) throws DatabaseWriteException {
        // FIXME: Might be worthwhile collecting all queries into one statement?
        // But then if something errors out it's hard to find what it was
        for (DataAccess da : list.keySet()) {
            update(da, list.get(da));
        }
    }

    @Override
    public void remove(DataAccess dataAccess, Map<String, Object> filters) throws DatabaseWriteException {
        Connection conn = JdbcConnectionManager.getConnection();

        this.deleteRows(conn, dataAccess, filters);
    }

    @Override
    public void removeAll(DataAccess dataAccess, Map<String, Object> filters) throws DatabaseWriteException {
        Connection conn = JdbcConnectionManager.getConnection();

        this.deleteRows(conn, dataAccess, filters);
    }

    @Override
    public void load(DataAccess dataset, Map<String, Object> filters) throws DatabaseReadException {
        ResultSet rs = null;
        HashMap<String, Object> dataSet = new HashMap<String, Object>();
        try {
            rs = this.getResultSet(JdbcConnectionManager.getConnection(), dataset, filters, true);
            if (rs != null) {
                if (rs.next()) {
                    for (Column column : dataset.getTableLayout()) {
                        if (column.isList()) {
                            dataSet.put(column.columnName(), getList(column.dataType(), rs.getString(column.columnName())));
                        }
                        else if (column.dataType() == DataType.BOOLEAN) {
                            dataSet.put(column.columnName(), rs.getBoolean(column.columnName()));
                        }
                        else {
                            dataSet.put(column.columnName(), rs.getObject(column.columnName()));
                        }
                    }
                }
            }
        }
        catch (DatabaseReadException dre) {
            log.error(dre.getMessage(), dre);
        }
        catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        catch (DatabaseTableInconsistencyException dtie) {
            log.error(dtie.getMessage(), dtie);
        }
        finally {
            try {
                if (rs != null) {
                    PreparedStatement st = rs.getStatement() instanceof PreparedStatement ? (PreparedStatement)rs.getStatement() : null;
                    close(null, st, rs);
                }
            }
            catch (SQLException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        try {
            if (!dataSet.isEmpty()) {
                dataset.load(dataSet);
            }
        }
        catch (DatabaseAccessException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void loadAll(DataAccess typeTemplate, List<DataAccess> datasets, Map<String, Object> filters) throws DatabaseReadException {
        ResultSet rs = null;
        List<HashMap<String, Object>> stuff = new ArrayList<HashMap<String, Object>>();
        try {
            rs = this.getResultSet(JdbcConnectionManager.getConnection(), typeTemplate, filters, false);
            if (rs != null) {
                while (rs.next()) {
                    HashMap<String, Object> dataSet = new HashMap<String, Object>();
                    for (Column column : typeTemplate.getTableLayout()) {
                        if (column.isList()) {
                            dataSet.put(column.columnName(), getList(column.dataType(), rs.getString(column.columnName())));
                        }
                        else if (column.dataType() == DataType.BOOLEAN) {
                            dataSet.put(column.columnName(), rs.getBoolean(column.columnName()));
                        }
                        else {
                            dataSet.put(column.columnName(), rs.getObject(column.columnName()));
                        }
                    }
                    stuff.add(dataSet);
                }
            }
        }
        catch (DatabaseReadException dre) {
            log.error(dre.getMessage(), dre);
        }
        catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        catch (DatabaseTableInconsistencyException dtie) {
            log.error(dtie.getMessage(), dtie);
        }
        finally {
            try {
                if (rs != null) {
                    PreparedStatement st = rs.getStatement() instanceof PreparedStatement ? (PreparedStatement)rs.getStatement() : null;
                    close(null, st, rs);
                }
            }
            catch (SQLException ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        try {
            for (HashMap<String, Object> temp : stuff) {
                DataAccess newData = typeTemplate.getInstance();
                newData.load(temp);
                datasets.add(newData);
            }
        }
        catch (DatabaseAccessException dae) {
            log.error(dae.getMessage(), dae);
        }
    }

    @Override
    public void updateSchema(DataAccess schemaTemplate) throws DatabaseWriteException {
        ResultSet rs = null;

        try {
            // First check if the table exists, if it doesn't we'll skip the rest
            // of this method since we're creating it fresh.
            DatabaseMetaData metadata = JdbcConnectionManager.getConnection().getMetaData();
            rs = metadata.getTables(null, null, schemaTemplate.getName(), null);

            boolean hasNext = rs.next();
            rs.close(); // Close here; otherwise we can't drop stuff.

            if (!hasNext) {
                createTable(schemaTemplate);
            }
            else {

                LinkedList<String> toRemove = new LinkedList<String>();
                HashMap<String, Column> toAdd = new HashMap<String, Column>();
                Iterator<Column> it = schemaTemplate.getTableLayout().iterator();

                Column column;
                while (it.hasNext()) {
                    column = it.next();
                    toAdd.put(column.columnName(), column);
                }

                for (String col : getColumnNames(schemaTemplate)) {
                    if (!toAdd.containsKey(col)) {
                        toRemove.add(col);
                    }
                    else {
                        toAdd.remove(col);
                    }
                }

                if (!toRemove.isEmpty()) {
                    List<String> columnNames = getColumnNames(schemaTemplate);
                    columnNames.removeAll(toRemove);
                    retainColumns(schemaTemplate, columnNames);
                }
                for (Map.Entry<String, Column> entry : toAdd.entrySet()) {
                    try {
                        insertColumn(schemaTemplate.getName(), entry.getValue(), schemaTemplate.getClass().getField(entry.getValue().columnName()).get(schemaTemplate));
                    }
                    catch (IllegalAccessException iaex) {
                        Canary.log.warn("", iaex);
                    }
                    catch (NoSuchFieldException nsfex) {
                        Canary.log.warn("", nsfex);
                    }
                }
            }
        }
        catch (SQLException sqle) {
            throw new DatabaseWriteException("Error updating SQLite schema: " + sqle.getMessage(), sqle);
        }
        catch (DatabaseTableInconsistencyException dtie) {
            log.error("Error updating SQLite schema." + dtie.getMessage(), dtie);
        }
        finally {
            close(null, null, rs);
        }
    }

    public void createTable(DataAccess data) throws DatabaseWriteException {
        PreparedStatement ps = null;

        try {
            StringBuilder fields = new StringBuilder();
            List<String> primary = new ArrayList<String>();
            HashMap<Column, Object> columns = data.toDatabaseEntryList();
            Iterator<Column> it = columns.keySet().iterator();
            Column column;
            while (it.hasNext()) {
                column = it.next();
                fields.append("`").append(column.columnName()).append("` ");
                fields.append(getDataTypeSyntax(column.dataType()));
                if (column.autoIncrement()) {
                    fields.append(" AUTOINCREMENT");
                }
                else if (column.columnType() == Column.ColumnType.UNIQUE) {
                    fields.append(" UNIQUE");
                }

                // NOT NULL
                if (column.notNull()) {
                    fields.append(" NOT NULL");
                }

                // DEFAULT
                try {
                    Object defVal = data.getClass().getField(column.columnName()).get(data);
                    if (defVal != null) {
                        fields.append(" DEFAULT ").append(defVal.toString());
                    }
                }
                catch (IllegalAccessException e) {
                    // OOPS
                }
                catch (NoSuchFieldException e) {
                    // OOPS
                }

                if (it.hasNext()) {
                    fields.append(", ");
                }
                if (column.columnType() == Column.ColumnType.PRIMARY) {
                    if (column.dataType() == DataType.INTEGER) {
                        primary.add(column.columnName().concat(" ASC"));
                    }
                    else {
                        primary.add(column.columnName());
                    }
                }
            }

            String primaryFields = "";
            if (primary.size() > 0) {
                primaryFields = " PRIMARY KEY (" + StringUtils.joinString(primary.toArray(new String[primary.size()]), ",", 0) + ")";
            }
            // CREATE TABLE something (column1, column2, column3, PRIMARY KEY (column1, column2));
            String state = "CREATE TABLE IF NOT EXISTS `" + data.getName() + "` (" + fields.toString() + "" + primaryFields + ")";
            ps = JdbcConnectionManager.getConnection().prepareStatement(state);
            if (ps.execute()) {
                log.debug("Statment Executed!");
            }
        }
        catch (SQLException ex) {
            throw new DatabaseWriteException("Error creating SQLite table '" + data.getName() + "'", ex);
        }
        catch (DatabaseTableInconsistencyException ex) {
            throw new DatabaseWriteException("Error creating SQLite table '" + data.getName() + "'", ex);
        }
        finally {
            close(null, ps, null);
        }
    }

    public void insertColumn(String tableName, Column column, Object defVal) throws DatabaseWriteException {
        PreparedStatement ps = null;

        try {
            if (column != null && !column.columnName().trim().equals("")) {
                ps = JdbcConnectionManager.getConnection().prepareStatement("ALTER TABLE `" + tableName
                                                                                    + "` ADD `" + column.columnName()
                                                                                    + "` " + getDataTypeSyntax(column.dataType())
                                                                                    + (column.notNull() ? " NOT NULL" : "")
                                                                                    + (defVal != null ? " DEFAULT " + defVal.toString() : "")
                                                                           );
                ps.execute();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseWriteException("Error adding SQLite column: " + column.columnName());
        }
        finally {
            close(null, ps, null);
        }
    }

    // SQLite sucks.
    // precondition: toRetain is not null and not empty.
    public void retainColumns(DataAccess table, List<String> toRetain) throws DatabaseWriteException {
        Statement stmt = null;

        try {
            StringBuilder concatColumns = new StringBuilder();
            for (String column : toRetain) {
                if (concatColumns.length() > 0) {
                    concatColumns.append(", ");
                }

                concatColumns.append(column);
            }

            log.debug(concatColumns);

            String tableName = table.getName();
            String tempTable = "" + tableName + "_temp";

            stmt = JdbcConnectionManager.getConnection().createStatement();
            stmt.addBatch("CREATE TEMPORARY TABLE " + tempTable + " (" + concatColumns + ")");
            stmt.addBatch("INSERT INTO " + tempTable + " SELECT " + concatColumns + " FROM " + tableName + ";");
            stmt.addBatch("DROP TABLE " + tableName + ";");
            stmt.executeBatch();

            createTable(table);

            stmt.clearBatch();
            stmt.addBatch("INSERT INTO " + tableName + " SELECT " + concatColumns + " FROM " + tempTable + ";");
            stmt.addBatch("DROP TABLE " + tempTable + ";");
            stmt.executeBatch();
        }
        catch (SQLException ex) {
            throw new DatabaseWriteException("Error retaining SQLite columns (something went horribly wrong)", ex);
        }
        finally {
            close(null, stmt, null);
        }
    }

    public boolean doesEntryExist(DataAccess data) throws DatabaseWriteException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean toRet = false;

        try {
            StringBuilder sb = new StringBuilder();
            HashMap<Column, Object> columns = data.toDatabaseEntryList();
            Iterator<Column> it = columns.keySet().iterator();

            Column column;
            while (it.hasNext()) {
                column = it.next();
                if (!column.autoIncrement()) {
                    if (sb.length() > 0) {
                        sb.append(" AND '").append(column.columnName());
                    }
                    else {
                        sb.append("'").append(column.columnName());
                    }
                    sb.append("' = ?");
                }
            }
            ps = JdbcConnectionManager.getConnection().prepareStatement("SELECT * FROM `" + data.getName() + "` WHERE " + sb.toString());
            it = columns.keySet().iterator();

            int index = 1;
            while (it.hasNext()) {
                column = it.next();
                if (!column.autoIncrement()) {
                    ps.setObject(index, columns.get(column));
                    index++;
                }
            }
            rs = ps.executeQuery();
            if (rs != null) {
                toRet = rs.next();
            }
        }
        catch (SQLException ex) {
            throw new DatabaseWriteException(ex.getMessage() + " Error checking SQLite Entry Key in "
                                                     + data.toString()
            );
        }
        catch (DatabaseTableInconsistencyException ex) {
            LogManager.getLogger().error("", ex);
        }
        finally {
            close(null, ps, rs);
        }
        return toRet;
    }

    /**
     * Close a set of working data.
     * This will return all the data to the connection pool.
     * You can pass null for objects that are not relevant in your given context
     *
     * @param c
     *         the connection object
     * @param ps
     *         the prepared statement
     * @param rs
     *         the result set
     */
    private void close(Connection c, Statement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (c != null) {
                c.close();
            }
        }
        catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    public ResultSet getResultSet(Connection conn, DataAccess data, Map<String, Object> filters, boolean limitOne) throws DatabaseReadException {
        PreparedStatement ps;
        ResultSet toRet;

        try {

            if (filters.size() > 0) {
                StringBuilder sb = new StringBuilder();
                Object[] fieldNames = filters.keySet().toArray();
                for (int i = 0; i < fieldNames.length && i < fieldNames.length; i++) {
                    sb.append("`").append(fieldNames[i]);
                    if (i + 1 < fieldNames.length) {
                        sb.append("`=? AND ");
                    }
                    else {
                        sb.append("`=?");
                    }
                }
                if (limitOne) {
                    sb.append(" LIMIT 1");
                }
                ps = conn.prepareStatement("SELECT * FROM `" + data.getName() + "` WHERE " + sb.toString());
                for (int i = 0; i < fieldNames.length && i < fieldNames.length; i++) {
                    String fieldName = String.valueOf(fieldNames[i]);
                    Column col = data.getColumnForName(fieldName);
                    if (col == null) {
                        throw new DatabaseReadException("Error fetching SQLite ResultSet in " + data.getName() + ". Column " + fieldNames[i] + " does not exist!");
                    }
                    setToStatement(i + 1, filters.get(fieldName), ps, col.dataType());
                }
            }
            else {
                if (limitOne) {
                    ps = conn.prepareStatement("SELECT * FROM `" + data.getName() + "` LIMIT 1");
                }
                else {
                    ps = conn.prepareStatement("SELECT * FROM `" + data.getName() + "`");
                }
            }
            toRet = ps.executeQuery();
        }
        catch (SQLException ex) {
            throw new DatabaseReadException("Error fetching SQLite ResultSet in " + data.getName(), ex);
        }
        catch (DatabaseReadException ex) {
            throw new DatabaseReadException("Error fetching SQLite ResultSet in " + data.getName(), ex);
        }
        catch (DatabaseWriteException ex) {
            throw new DatabaseReadException("Error fetching SQLite ResultSet in " + data.getName(), ex);
        }

        return toRet;
    }

    public void deleteRows(Connection conn, DataAccess data, Map<String, Object> filters) throws DatabaseWriteException {
        PreparedStatement ps;
        try {
            if (filters.size() > 0) {
                StringBuilder sb = new StringBuilder();
                Object[] fieldNames = filters.keySet().toArray();
                for (int i = 0; i < fieldNames.length && i < fieldNames.length; i++) {
                    sb.append("`").append(fieldNames[i]);
                    if (i + 1 < fieldNames.length) {
                        sb.append("`=? AND ");
                    }
                    else {
                        sb.append("`=?");
                    }
                }
                ps = conn.prepareStatement("DELETE FROM `" + data.getName() + "` WHERE " + sb.toString());
                for (int i = 0; i < fieldNames.length && i < fieldNames.length; i++) {
                    String fieldName = String.valueOf(fieldNames[i]);
                    Column col = data.getColumnForName(fieldName);
                    if (col == null) {
                        throw new DatabaseReadException("Error deleting from SQLite table " + data.getName() + ". Column " + fieldNames[i] + " does not exist!");
                    }
                    setToStatement(i + 1, filters.get(fieldName), ps, col.dataType());
                }
            }
            else {
                ps = conn.prepareStatement("DELETE FROM `" + data.getName() + "`");
            }
            ps.execute();
        }
        catch (SQLException ex) {
            throw new DatabaseWriteException("Error deleting from SQLite table " + data.getName(), ex);
        }
        catch (DatabaseReadException ex) {
            throw new DatabaseWriteException("Error deleting from SQLite table " + data.getName(), ex);
        }
        catch (DatabaseWriteException ex) {
            throw new DatabaseWriteException("Error deleting from SQLite table " + data.getName(), ex);
        }
    }

    /**
     * Sets the given object as the given type to the given index
     * of the given PreparedStatement.
     *
     * @param index
     *         the index to set to
     * @param o
     *         the object to set
     * @param ps
     *         the prepared statement
     * @param t
     *         the DataType hint
     *
     * @throws DatabaseWriteException
     *         when an SQLException was raised or when the data type doesn't match the objects type
     */
    private void setToStatement(int index, Object o, PreparedStatement ps, Column.DataType t) throws DatabaseWriteException {
        try {
            switch (t) {
                case BYTE:
                case INTEGER:
                case LONG:
                case SHORT:
                case BOOLEAN: //SQlite doesn't know boolean values, it converts it to tinyint
                    ps.setInt(index, (Integer)o);
                    break;
                case FLOAT:
                case DOUBLE:
                    ps.setDouble(index, (Double)o);
                    break;
                case STRING:
                    ps.setString(index, (String)o);
            }
        }
        catch (SQLException e) {
            throw new DatabaseWriteException("Failed to set property to prepared statement!", e);
        }
        catch (ClassCastException e) {
            throw new DatabaseWriteException("Failed to set property to prepared statement!", e);
        }
    }

    public List<String> getColumnNames(DataAccess data) {
        Statement s = null;
        ResultSet rs = null;

        ArrayList<String> columns = new ArrayList<String>();
        String columnName;

        try {
            s = JdbcConnectionManager.getConnection().createStatement();
            rs = s.executeQuery("SELECT * FROM '" + data.getName() + "'");
            ResultSetMetaData rsMeta = rs.getMetaData();
            for (int index = 1; index <= rsMeta.getColumnCount(); index++) {
                columnName = rsMeta.getColumnLabel(index);
                columns.add(columnName);
            }
        }
        catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        finally {
            close(null, s, rs);
        }
        return columns;
    }

    public String getDataTypeSyntax(Column.DataType type) {
        switch (type) {
            case BYTE:
            case INTEGER:
            case LONG:
            case SHORT:
            case BOOLEAN:
                return "INTEGER";
            case FLOAT:
            case DOUBLE:
                return "REAL";
            case STRING:
                return "TEXT";
        }
        return "";
    }

    /**
     * Gets a Java List representation from the SQLite String.
     *
     * @param type
     * @param field
     *
     * @return
     */
    private List<Comparable<?>> getList(Column.DataType type, String field) {
        List<Comparable<?>> list = new ArrayList<Comparable<?>>();
        if (field == null) {
            return list;
        }
        switch (type) {
            case BYTE:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Byte.valueOf(s));
                }
                break;
            case INTEGER:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Integer.valueOf(s));
                }
                break;
            case FLOAT:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Float.valueOf(s));
                }
                break;
            case DOUBLE:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Double.valueOf(s));
                }
                break;
            case LONG:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Long.valueOf(s));
                }
                break;
            case SHORT:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Short.valueOf(s));
                }
                break;
            case STRING:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(s);
                }
                break;
            case BOOLEAN:
                for (String s : field.split(this.LIST_REGEX)) {
                    if (s.equals(NULL_STRING)) {
                        list.add(null);
                        continue;
                    }
                    list.add(Boolean.valueOf(s));
                }
                break;
        }
        return list;
    }

    private String generateQuery(DataAccess data) throws DatabaseTableInconsistencyException {
        StringBuilder fields = new StringBuilder();
        StringBuilder values = new StringBuilder();
        HashMap<Column, Object> columns = data.toDatabaseEntryList();
        Iterator<Column> it = columns.keySet().iterator();

        Column column;
        while (it.hasNext()) {
            column = it.next();
            if (!column.autoIncrement()) {
                fields.append("`").append(column.columnName()).append("`").append(",");
                values.append("?").append(",");
            }
        }
        if (fields.length() > 0) {
            fields.deleteCharAt(fields.length() - 1);
        }
        if (values.length() > 0) {
            values.deleteCharAt(values.length() - 1);
        }
        return "INSERT INTO `" + data.getName() + "` (" + fields.toString() + ") VALUES(" + values.toString() + ")";
    }

    /**
     * Get the database entry for a Java List.
     *
     * @param list
     *
     * @return a string representation of the passed list.
     */
    public String getString(List<?> list) {
        if (list == null) {
            return NULL_STRING;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o == null) {
                sb.append(NULL_STRING);
            }
            else {
                sb.append(String.valueOf(o));
            }
            if (it.hasNext()) {
                sb.append(this.LIST_REGEX);
            }
        }
        return sb.toString();
    }
}
