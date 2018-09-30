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

    protected abstract void addResumeToArray(Resume resume, int index);

    protected abstract void removeResumeFromArray(int index);

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
    protected Resume getResume(String uuid, int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    @Override
    protected void addResume(Resume resume, int index) {
        checkOverflow(resume);
        addResumeToArray(resume, index);
        increaseStorageSize();
    }

    @Override
    protected void removeResume(String uuid, int index) {
        removeResumeFromArray(index);
        deleteLastElement();
        reduceStorageSize();
    }

    private void deleteLastElement() {
        storage[size - 1] = null;
    }

    private void increaseStorageSize() {
        size++;
    }

    private void reduceStorageSize() {
        size--;
    }

    private void checkOverflow(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new OverflowStorageException(resume.getUuid());
        }
    }
}
