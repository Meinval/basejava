package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract int size();

    public abstract Resume[] getAll();

    public abstract void clear();

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void addResume(Resume resume, Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract boolean checkExistInStorage(Object searchKey);

    @Override
    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (!checkExistInStorage(searchKey)) {
            updateResume(r, searchKey);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String resumeUuid = r.getUuid();
        Object searchKey = getSearchKey(resumeUuid);
        if (checkExistInStorage(searchKey)) {
            addResume(r, searchKey);
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!checkExistInStorage(searchKey)) {
            removeResume(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!checkExistInStorage(searchKey)) {
            return getResume(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}