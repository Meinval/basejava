package basejava.storage;

import basejava.exception.NotExistStorageException;
import basejava.model.AbstractSection;
import basejava.model.ContactType;
import basejava.model.Resume;
import basejava.model.SectionType;
import basejava.sql.SqlHelper;
import basejava.util.JsonParser;

import java.sql.*;
import java.util.*;

public class SqlStorage implements Storage {
    private final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume");
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.transactionalExecute(conn -> {
            Resume resume;
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume WHERE uuid =?")) {
                ps.setString(1, uuid);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    throw new NotExistStorageException(uuid);
                }
                resume = new Resume(uuid, rs.getString("full_name"));
            }
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM contact WHERE resume_uuid =?")) {
                ps.setString(1, uuid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    getContactsFromDb(rs, resume);
                }
            }
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM section s WHERE resume_uuid =?")) {
                ps.setString(1, uuid);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    getSectionsFromDb(rs, resume);
                }
            }
            return resume;
        });
    }

    @Override
    public void update(Resume r) {
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE resume SET full_name = ? WHERE uuid = ?")) {
                ps.setString(1, r.getFullName());
                ps.setString(2, r.getUuid());
                ps.execute();
                if (ps.executeUpdate() == 0) {
                    throw new NotExistStorageException(r.getUuid());
                }
            }
            deleteAllContactsFromDb(r, conn);
            deleteAllSectionsFromDb(r, conn);
            if (!r.getContactsMap().isEmpty()) {
                insertContacts(r, conn);
            }
            if (!r.getSectionsMap().isEmpty()) {
                insertSections(r, conn);
            }
            return null;
        });
    }

    @Override
    public void save(Resume r) {
        sqlHelper.transactionalExecute(conn -> {
                    try (PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (uuid, full_name) VALUES (?,?)")) {
                        ps.setString(1, r.getUuid());
                        ps.setString(2, r.getFullName());
                        ps.execute();
                    }
            insertContacts(r, conn);
            insertSections(r, conn);
                    return null;
                }
        );
    }

    @Override
    public void delete(String uuid) {
        sqlHelper.execute("DELETE FROM resume WHERE uuid=?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }
            return null;
        });
    }

    @Override
    public List<Resume> getAllSorted() {
        Map<String, Resume> map = new LinkedHashMap<>();
        return sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume r ORDER BY full_name, uuid")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String uuid = rs.getString("uuid").trim();
                    Resume resume = new Resume(uuid, rs.getString("full_name"));
                    map.put(uuid, resume);
                }
            }
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM contact c ORDER BY c.resume_uuid")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String resumeUuid = rs.getString("resume_uuid").trim();
                    String value = rs.getString("value");
                    String type = rs.getString("type");
                    if (!Objects.isNull(type)) {
                        map.get(resumeUuid).addContact(ContactType.valueOf(type), value);
                    }
                }
            }
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM section s ORDER BY s.resume_uuid")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String resumeUuid = rs.getString("resume_uuid").trim();
                    String content = rs.getString("content");
                    String type = rs.getString("type");
                    if (!Objects.isNull(type)) {
                        map.get(resumeUuid).addSection(SectionType.valueOf(type), JsonParser.read(content, AbstractSection.class));
                    }
                }
            }
            return new ArrayList<>(map.values());
        });
    }

    @Override
    public int size() {
        return sqlHelper.execute("SELECT count(*) FROM resume", ps -> {
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }

    private void getSectionsFromDb(ResultSet rs, Resume r) throws SQLException {
        do {
            String content = rs.getString("content");
            String type = rs.getString("type");
            if (!Objects.isNull(type)) {
                r.addSection(SectionType.valueOf(type), JsonParser.read(content, AbstractSection.class));
            }
        } while (rs.next());
    }

    private void getContactsFromDb(ResultSet rs, Resume r) throws SQLException {
        do {
            String value = rs.getString("value");
            String type = rs.getString("type");
            if (!Objects.isNull(type)) {
                r.addContact(ContactType.valueOf(type), value);
            }
        } while (rs.next());
    }

    private void insertContacts(Resume r, Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO contact (resume_uuid, type, value) VALUES (?,?,?)")) {
            for (Map.Entry<ContactType, String> e : r.getContactsMap().entrySet()) {
                ps.setString(1, r.getUuid());
                ps.setString(2, e.getKey().name());
                ps.setString(3, e.getValue());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertSections(Resume r, Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO section (resume_uuid, type, content) VALUES (?,?,?)")) {
            for (Map.Entry<SectionType, AbstractSection> e : r.getSectionsMap().entrySet()) {
                ps.setString(1, r.getUuid());
                ps.setString(2, e.getKey().name());
                ps.setString(3, JsonParser.write(e.getValue(), AbstractSection.class));
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void deleteAllContactsFromDb(Resume r, Connection conn) throws SQLException {
        deleteResumeInfoFromDb(r.getUuid(), conn, "DELETE from contact where resume_uuid = ?");
    }

    private void deleteAllSectionsFromDb(Resume r, Connection conn) throws SQLException {
        deleteResumeInfoFromDb(r.getUuid(), conn, "DELETE from section where resume_uuid = ?");
    }

    private void deleteResumeInfoFromDb(String uuid, Connection connection, String query) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, uuid);
            ps.execute();
        }
    }
}