import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final static String ERROR_RESUME_NOT_FOUND = "Resume not exist in storage";
    private final static String ERROR_RESUME_FOUND = "Resume already exist in storage";
    private final static String ERROR_STORAGE_OVERLOAD = "Cant save, storage overloaded";
    private Resume[] storage = new Resume[10000];
    /**
     * Add realSize counter, that contains size of array
     */
    private int realSize = 0;

    /**
     * Update resume if it founded, else error message
     *
     * @param resume inputed Resume
     */
    void update(Resume resume) {
        int foundResumeId = checkExistResume(resume.uuid);
        if (foundResumeId != -1) {
            storage[foundResumeId] = resume;
        } else {
            printMessage(ERROR_RESUME_NOT_FOUND);
        }
    }

    /**
     * Add resume to array, increase array size counter
     *
     * @param resume inputed Resume
     */
    void save(Resume resume) {
        int foundResumeId = checkExistResume(resume.uuid);
        if (foundResumeId == -1) {
            if (realSize >= storage.length) {
                printMessage(ERROR_STORAGE_OVERLOAD);
            } else {
                storage[realSize] = resume;
                realSize++;
            }
        } else {
            printMessage(ERROR_RESUME_FOUND);
        }
    }

    /**
     * Clear array. Also reset realSize
     */
    void clear() {
        Arrays.fill(storage, 0, realSize, null);
        realSize = 0;
    }

    /**
     * @param uuid inputed id name
     * @return element of array where id = uuid. If cant find, return null
     */
    Resume get(String uuid) {
        int foundResumeId = checkExistResume(uuid);
        if (foundResumeId != -1) {
            return storage[foundResumeId];
        }
        printMessage(ERROR_RESUME_NOT_FOUND);
        return null;
    }

    /**
     * Remove resume from array, descrease array size counter
     *
     * @param uuid inputed id name
     */
    void delete(String uuid) {
        int foundResumeId = checkExistResume(uuid);
        if (foundResumeId != -1) {
            System.arraycopy(storage, foundResumeId + 1, storage, foundResumeId, realSize - 1 - foundResumeId);
            realSize--;
        } else {
            printMessage(ERROR_RESUME_NOT_FOUND);
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

    /**
     * Check if storage have resume
     *
     * @param uuid inputed resume
     * @return -1 if not, position if have
     */
    private int checkExistResume(String uuid) {
        for (int i = 0; i < realSize; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
