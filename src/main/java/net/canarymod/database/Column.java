package net.canarymod.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field of a DataAccess object as a column in a database table.
 * This annotation also describes the column so that it will be handled properly in the database
 *
 * @author Chris (damagefilter)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    public enum DataType {
        INTEGER(Integer.class),
        FLOAT(Float.class),
        DOUBLE(Double.class),
        LONG(Long.class),
        SHORT(Short.class),
        BYTE(Byte.class),
        STRING(String.class),
        BOOLEAN(Boolean.class);

        private Class<?> cls;

        DataType(Class<?> cls) {
            this.cls = cls;
        }

        public boolean isAssignable(Class<?> cls) {
            return this.cls.isAssignableFrom(cls);
        }

        public static DataType fromString(String in) {
            for (DataType t : DataType.values()) {
                if (in.equalsIgnoreCase(t.name())) {
                    return t;
                }
            }
            return STRING;
        }

        public Class<?> getTypeClass() {
            return cls;
        }
    }

    public enum ColumnType {
        UNIQUE,
        PRIMARY,
        NORMAL;
    }

    String columnName();

    DataType dataType();

    ColumnType columnType() default ColumnType.NORMAL;

    /**
     * Should we auto-increment the value of this field?
     */
    boolean autoIncrement() default false;

    /**
     * Is this field an implementation of the List interface?
     */
    boolean isList() default false;

    boolean notNull() default false;
}
