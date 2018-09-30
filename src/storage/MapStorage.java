package storage;

import exception.NotExistStorageException;
import model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Map based storage for Resumes
 */

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new LinkedHashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[size()]);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Object index = null;
        try {
            if (Objects.nonNull(storage.get(uuid))) {
                index = uuid;
            }
        } catch (Exception e) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    @Override
    protected Resume getResume(Resume resume, Object searchKey) {
        return storage.get(resume.getUuid());
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void removeResume(Resume resume, Object searchKey) {
        storage.remove(resume.getUuid());
    }

    @Override
    protected boolean checkExistInStorage(Resume resume, Object searchKey) {
        return Objects.isNull(searchKey);
    }

    @Override
    protected boolean checkNotExistInStorage(Resume resume, Object searchKey) {
        return Objects.nonNull(searchKey);
    }
}
