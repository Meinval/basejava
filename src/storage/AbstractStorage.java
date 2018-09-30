package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract int size();

    public abstract Resume[] getAll();

    public abstract void clear();

    protected abstract int getIndex(String uuid);

    protected abstract Resume getResume(String uuid, int index);

    protected abstract void updateResume(Resume resume, int index);

    protected abstract void addResume(Resume resume, int index);

    protected abstract void removeResume(String uuid, int index);

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(r, index);
        }
    }

    @Override
    public void save(Resume r) {
        String resumeUuid = r.getUuid();
        int index = getIndex(resumeUuid);
        if (index > -1) {
            throw new ExistStorageException(resumeUuid);
        } else {
            addResume(r, index);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            removeResume(uuid, index);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(uuid, index);
    }
}
