package storage;

import model.Resume;

import java.util.*;

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
    public List<Resume> getListOfResume() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey);
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
    protected void removeResume(Object searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected boolean checkNotExistInStorage(Object searchKey) {
        return Objects.isNull(storage.get(searchKey));
    }
}
