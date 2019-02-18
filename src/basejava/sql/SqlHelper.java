package basejava.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SqlHelper {
    private static final Logger LOG = Logger.getLogger(SqlHelper.class.getName());
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute(String sql) {
        execute(sql, PreparedStatement::execute);
    }

    public <T> T execute(String sql, SqlExecutor<T> executor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw ExceptionUtil.convertException(e);
        }
    }
}
