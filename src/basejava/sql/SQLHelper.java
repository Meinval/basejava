package basejava.sql;

import basejava.Config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.logging.Logger;

public class SQLHelper {
    private static final Logger LOG = Logger.getLogger(SQLHelper.class.getName());

    public static DbSet execQuery(String query, Object... params) {
        DbSet dbSet = new DbSet();
        ResultSet resultSet;
        Connection currentConnection;
        int position = 1;

        ConnectionFactory connectionFactory = () -> DriverManager.getConnection(Config.get().getDbUrl(), Config.get().getDbUser(), Config.get().getDbPassword());
        try {
            currentConnection = connectionFactory.getConnection();
            PreparedStatement ps = currentConnection.prepareStatement(query);
            ps.setQueryTimeout(120);
            attachVariablesFromArray(ps, position, params);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                DbSetRow row = new DbSetRow();
                ResultSetMetaData metadata = resultSet.getMetaData();
                int cols = metadata.getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    row.put(metadata.getColumnLabel(i), resultSet.getObject(i));
                }
                dbSet.add(row);
            }
        } catch (Exception e) {
            LOG.warning(e.getLocalizedMessage());
        }
        return dbSet;
    }

    public static boolean execCall(String query, Object... params) {
        int position = 1;
        Connection currentConnection;
        ConnectionFactory connectionFactory = () -> DriverManager.getConnection(Config.get().getDbUrl(), Config.get().getDbUser(), Config.get().getDbPassword());
        try {
            currentConnection = connectionFactory.getConnection();
            PreparedStatement ps = currentConnection.prepareCall(query);
            ps.setQueryTimeout(120);
            attachVariablesFromArray(ps, position, params);
            ps.execute();
            return ps.getUpdateCount() >= 1;
        } catch (Exception e) {
            LOG.warning(e.getLocalizedMessage());
        }
        return false;
    }

    private static void attachVariablesFromArray(PreparedStatement ps, int position, Object[] params) throws SQLException {
        if (params != null) {
            for (Object o : params) {
                attachVariable(ps, o, position++);
            }
        }
    }

    private static void attachVariable(PreparedStatement stmt, Object variable, int position) throws SQLException {
        if (variable instanceof Long) {
            stmt.setLong(position, (Long) variable);
        } else if (variable instanceof String) {
            stmt.setString(position, (String) variable);
        } else if (variable instanceof Double) {
            stmt.setDouble(position, (Double) variable);
        } else if (variable instanceof Date) {
            stmt.setTimestamp(position, new Timestamp(((Date) variable).getTime()));
        } else if (variable instanceof BigDecimal) {
            stmt.setBigDecimal(position, (BigDecimal) variable);
        } else if (variable instanceof BigInteger) {
            stmt.setBigDecimal(position, new BigDecimal((BigInteger) variable));
        } else if (variable instanceof Integer) {
            stmt.setInt(position, (Integer) variable);
        } else if (variable instanceof Short) {
            stmt.setShort(position, (Short) variable);
        } else if (variable == null) {
            stmt.setNull(position, Types.NULL);
        } else if (variable instanceof Boolean) {
            stmt.setBoolean(position, (Boolean) variable);
        }
    }
}
