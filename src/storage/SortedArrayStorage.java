package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array sorted storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("model.Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            if (size >= STORAGE_LIMIT) {
                System.out.println("Storage overflow");
            } else {
                index = -(index) - 1;
                System.arraycopy(storage, index, storage, index + 1, size - index);
                storage[index] = r;
                size++;
            }
        } else {
            System.out.println("model.Resume " + r.getUuid() + " already exist");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("model.Resume " + uuid + " not exist");
        } else {
            Resume[] cloneStorage = new Resume[storage.length - 1];
            System.arraycopy(storage, 0, cloneStorage, 0, index);
            System.arraycopy(storage, index + 1, cloneStorage, index, size - 1 - index);
            storage = cloneStorage;
            size--;
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
