import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    /**
     * Add realSize counter, that contains size of array
     */
    private int realSize = 0;

    /**
     * Clear array. Also reset realSize
     */
    void clear() {
        Arrays.fill(storage, 0, realSize, null);
        realSize = 0;
    }

    /**
     * Add resume to array, increase array size counter
     *
     * @param resume inputed Resume
     */
    void save(Resume resume) {
        storage[realSize] = resume;
        realSize++;
    }

    /**
     * @param uuid inputed id name
     * @return element of array where id = uuid. If cant find, return null
     */
    Resume get(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    /**
     * Remove resume from array, descrease array size counter
     *
     * @param uuid inputed id name
     */
    void delete(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                System.arraycopy(storage, i + 1, storage, i, realSize - 1 - i);
                realSize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, realSize);
    }

    /**
     * @return array size counter
     */
    int size() {
        return realSize;
    }
}
