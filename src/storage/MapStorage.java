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
    protected void deleteLastElement() {

    }

    @Override
    protected void increaseStorageSize() {

    }

    @Override
    protected void reduceStorageSize() {

    }

    @Override
    protected void checkOverflow(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid) {
        int index = -1;
        try {
            if (Objects.nonNull(storage.get(uuid))) {
                index = 1;
            }
        } catch (Exception e) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.replace(r.getUuid(), r);
    }

    @Override
    protected void addResume(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void removeResume(String uuid, int index) {
        storage.remove(uuid);
    }
}
