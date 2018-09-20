package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array sorted storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    protected void addResume(Resume r, int index) {
        int indexInStorage = -(index) - 1;
        System.arraycopy(storage, indexInStorage, storage, indexInStorage + 1, size - indexInStorage);
        storage[indexInStorage] = r;
    }

    protected void removeResume(int index) {
        int checkLastPosition = size - index - 1;
        if (checkLastPosition != 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
