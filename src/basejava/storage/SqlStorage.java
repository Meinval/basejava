package basejava.storage;

import basejava.exception.ExistStorageException;
import basejava.exception.NotExistStorageException;
import basejava.model.Resume;
import basejava.sql.DbSet;
import basejava.sql.DbSetRow;
import basejava.sql.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {

    public SqlStorage() {
    }

    @Override
    public void clear() {
        String query = "DELETE FROM resume";
        SQLHelper.execCall(query);
    }

    @Override
    public Resume get(String uuid) {
        String query = "SELECT * FROM resume r WHERE r.uuid =?";
        DbSet dbSet = SQLHelper.execQuery(query, uuid);
        if (dbSet.isEmpty()) {
            throw new NotExistStorageException(uuid);
        }
        return new Resume(uuid, dbSet.getFirst().getString("full_name"));
    }

    @Override
    public void update(Resume r) {
        String query = "UPDATE resume t1 SET full_name=? WHERE t1.uuid=?";
        if (!SQLHelper.execCall(query, r.getFullName(), r.getUuid())) {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String query = "INSERT INTO resume (uuid, full_name) VALUES (?,?)";
        if (!SQLHelper.execCall(query, r.getUuid(), r.getFullName())) {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        String query = "delete from resume t1 WHERE t1.uuid=?";
        if (!SQLHelper.execCall(query, uuid)) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumes = new ArrayList<>();
        String query = "SELECT * FROM resume r order by r.full_name asc";
        DbSet dbSet = SQLHelper.execQuery(query);
        for (DbSetRow dbSetRow : dbSet) {
            resumes.add(new Resume(dbSetRow.getString("uuid").trim(), dbSetRow.getString("full_name")));
        }
        return resumes;
    }

    @Override
    public int size() {
        String query = "SELECT count(r.uuid) FROM resume r";
        DbSet dbSet = SQLHelper.execQuery(query);
        return dbSet.getFirst().getLong("count").intValue();
    }
}