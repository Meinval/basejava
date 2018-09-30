package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract int size();

    public abstract Resume[] getAll();

    public abstract void clear();

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getResume(Resume resume, Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void addResume(Resume resume, Object searchKey);

    protected abstract void removeResume(Resume resume, Object searchKey);

    protected abstract boolean checkExistInStorage(Resume resume, Object searchKey);

    protected abstract boolean checkNotExistInStorage(Resume resume, Object searchKey);

    @Override
    public void update(Resume r) {
        Object index = getSearchKey(r.getUuid());
        if (checkNotExistInStorage(r, index)) {
            updateResume(r, index);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        String resumeUuid = r.getUuid();
        Object index = getSearchKey(resumeUuid);
        if (checkExistInStorage(r, index)) {
            addResume(r, index);
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        Object index = getSearchKey(uuid);
        if (checkNotExistInStorage(new Resume(uuid), index)) {
            removeResume(new Resume(uuid), index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object index = getSearchKey(uuid);
        if (checkNotExistInStorage(new Resume(uuid), index)) {
            return getResume(new Resume(uuid), index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }
}