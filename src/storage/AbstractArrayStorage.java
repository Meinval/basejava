package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    /**
     * Storage max capacity
     */
    static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    /**
     * Storage size counter, that contains size of array
     */

    int size = 0;

    /**
     * Clear array. Also reset realSize
     */
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

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
     * @return element of array where id = uuid. If cant find, return null
     */
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("model.Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    /**
     * @param uuid inputed id name
     * @return index of array where id = uuid.
     */
    protected abstract int getIndex(String uuid);

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
