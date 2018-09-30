package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size()]);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Object index = null;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    protected Resume getResume(Resume resume, Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.set((int) searchKey, resume);
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        storage.add(resume);
    }

    @Override
    protected void removeResume(Resume resume, Object searchKey) {
        storage.remove((int) searchKey);
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