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
    protected Resume getResume(Resume resume, Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage[(int) searchKey] = resume;
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        checkOverflow(resume);
        addResumeToArray(resume, (int) searchKey);
        increaseStorageSize();
    }

    @Override
    protected void removeResume(Resume resume, Object searchKey) {
        removeResumeFromArray((int) searchKey);
        deleteLastElement();
        reduceStorageSize();
    }

    @Override
    protected boolean checkExistInStorage(Resume resume, Object searchKey) {
        return (int) searchKey <= -1;
    }

    @Override
    protected boolean checkNotExistInStorage(Resume resume, Object searchKey) {
        return (int) searchKey >= 0;
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
