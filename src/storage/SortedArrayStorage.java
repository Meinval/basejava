package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.OverflowStorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array sorted storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            if (size() >= STORAGE_LIMIT) {
                throw new OverflowStorageException(r.getUuid());
            } else {
                index = -(index) - 1;
                System.arraycopy(storage, index, storage, index + 1, size() - index);
                storage[index] = r;
                setSize(size() + 1);
            }
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            System.arraycopy(storage, index + 1, storage, index, size() - index - 1);
            setSize(size() - 1);
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size(), searchKey);
    }
}
