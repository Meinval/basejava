package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array sorted storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    public void addResume(Resume r, int index) {
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size() - index);
        storage[index] = r;
    }

    public void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size() - index - 1);
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size(), searchKey);
    }
}
