package storage;

import exception.OverflowStorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected int size = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void deleteLastElement() {
        storage[size - 1] = null;
    }

    @Override
    protected void increaseStorageSize() {
        size++;
    }

    @Override
    protected void reduceStorageSize() {
        size--;
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return storage[index];
    }

    @Override
    protected void checkOverflow(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new OverflowStorageException(resume.getUuid());
        }
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage[index] = r;
    }
}
