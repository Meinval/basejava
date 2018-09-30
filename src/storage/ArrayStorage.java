package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addResumeToArray(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void removeResumeFromArray(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}