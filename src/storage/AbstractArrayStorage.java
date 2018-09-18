package storage;

import exception.NotExistStorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    /**
     * Update resume if it founded, else error message
     *
     * @param r inputed resume to update
     */

    public abstract void update(Resume r);

    /**
     * Add resume to array, increase array size counter
     *
     * @param r inputed resume to save
     */

    public abstract void save(Resume r);

    /**
     * Remove resume from array, descrease array size counter
     *
     * @param uuid inputed id name
     */

    public abstract void delete(String uuid);


    /**
     * @param uuid inputed id name
     * @return index of array where id = uuid.
     */

    protected abstract int getIndex(String uuid);

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

    /**
     * change array size counter
     */

    void setSize(int size) {
        this.size = size;
    }
}
