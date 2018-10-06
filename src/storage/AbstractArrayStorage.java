package storage;

import exception.OverflowStorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

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
    public List<Resume> getListOfResume() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage[(int) searchKey] = resume;
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        if (size >= STORAGE_LIMIT) {
            throw new OverflowStorageException(resume.getUuid());
        }
        addResumeToArray(resume, (int) searchKey);
        size++;
    }

    @Override
    protected void removeResume(Object searchKey) {
        removeResumeFromArray((int) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean checkNotExistInStorage(Object searchKey) {
        return (int) searchKey <= -1;
    }
}
