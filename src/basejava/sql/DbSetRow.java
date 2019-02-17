package basejava.sql;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.TreeMap;

public class DbSetRow extends TreeMap<String, Object> {
    public Long getLong(String key) {
        Object value = getValue(key);
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).longValue();
        } else if (value instanceof String) {
            Long longValue = null;
            try {
                longValue = Long.parseLong((String) value);
            } catch (NumberFormatException nfe) {
                longValue = Double.valueOf((String) value).longValue();
            }
            return longValue;
        } else if (value instanceof Double) {
            return ((Double) value).longValue();
        } else if (value == null) {
            return null;
        }
        return (Long) value;
    }

    private Object getValue(String key) {
        return get(key.toLowerCase());
    }

    public BigDecimal getBigDecimal(String key) {
        Object value = getValue(key);
        if (value instanceof String) {
            return new BigDecimal((String) value);
        }
        return (BigDecimal) value;
    }

    public Double getDouble(String key) {
        Object value = getValue(key);
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue();
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else if (value == null) {
            return null;
        }
        return (Double) value;
    }

    public String getString(String key) {
        if (getValue(key) == null) {
            return null;
        }
        return getValue(key).toString();
    }

    public Clob getClob(String key) {
        if (getValue(key) == null) {
            return null;
        }
        return (Clob) getValue(key);
    }

    public Boolean getBoolean(String key) {
        Object value = getValue(key);

        if (value instanceof String) {
            return Boolean.parseBoolean(value.toString().toLowerCase());
        } else if (value instanceof Integer && value.equals(1)) {
            return true;
        } else if (value instanceof BigDecimal && value != null && ((BigDecimal) value).intValue() == 1) {
            return true;
        }
        return false;
    }

    public Timestamp getTimestamp(String key) {
        Object value = getValue(key);

        if (value instanceof Timestamp) {
            return (Timestamp) value;
        } else if (value instanceof String) {
            return Timestamp.valueOf(value.toString());
        }
        return null;
    }

    public Integer getInteger(String key) {
        Object value = getValue(key);
        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).intValue();
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else if (value == null) {
            return null;
        }
        return (Integer) value;
    }

    public BigInteger getBigInteger(String key) {
        Object obj = getValue(key);

        if (obj instanceof String) {
            return new BigInteger((String) obj);
        }

        return (BigInteger) obj;
    }
}
