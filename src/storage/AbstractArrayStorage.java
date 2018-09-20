package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.OverflowStorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    /**
     * Add resume to storage
     *
     * @param resume resume to add
     * @param index  resume position in array
     */
    protected abstract void addResume(Resume resume, int index);

    /**
     * Remove resume from storage
     *
     * @param index resume to remove
     */
    protected abstract void removeResume(int index);

    /**
     * @param uuid inputed id name
     * @return index of array where id = uuid.
     */

    protected abstract int getIndex(String uuid);

    /**
     * Update resume if it founded, else error message
     *
     * @param r inputed resume to update
     */

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    /**
     * Add resume to array, increase array size counter
     *
     * @param r inputed resume to save
     */

    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            throw new OverflowStorageException(r.getUuid());
        } else {
            String resumeUuid = r.getUuid();
            int index = getIndex(resumeUuid);
            if (index > -1) {
                throw new ExistStorageException(resumeUuid);
            } else {
                addResume(r, index);
                size++;
            }
        }
    }

    /**
     * Remove resume from array, descrease array size counter
     *
     * @param uuid inputed id name
     */

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            removeResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * Clear array. Also reset realSize
     */

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * @param uuid inputed id name
     * @return element of array where id = uuid. If cant find, return null
     */

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * @return array size counter
     */

    public int size() {
        return size;
    }
}
