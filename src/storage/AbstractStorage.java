package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public abstract int size();

    public abstract List<Resume> getListOfResume();

    public abstract void clear();

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void addResume(Resume resume, Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract boolean checkNotExistInStorage(Object searchKey);

    @Override
    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (!checkNotExistInStorage(searchKey)) {
            updateResume(r, searchKey);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String resumeUuid = r.getUuid();
        Object searchKey = getSearchKey(resumeUuid);
        if (checkNotExistInStorage(searchKey)) {
            addResume(r, searchKey);
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!checkNotExistInStorage(searchKey)) {
            removeResume(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!checkNotExistInStorage(searchKey)) {
            return getResume(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getListOfResume();
        Collections.sort(list);
        return list;
    }
}