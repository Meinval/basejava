package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.OverflowStorageException;
import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            throw new ExistStorageException(r.getUuid());
        } else if (size() >= STORAGE_LIMIT) {
            throw new OverflowStorageException(r.getUuid());
        } else {
            storage[size()] = r;
            setSize(size() + 1);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        } else {
            storage[index] = storage[size() - 1];
            storage[size() - 1] = null;
            setSize(size() - 1);
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}