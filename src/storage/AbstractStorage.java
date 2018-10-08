package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage, Comparator<Resume> {

    public abstract List<Resume> getListOfResume();

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void addResume(Resume resume, Object searchKey);

    protected abstract void removeResume(Object searchKey);

    protected abstract boolean checkNotExistInStorage(Object searchKey);

    @Override
    public void update(Resume resume) {
        updateResume(resume, checkExistence(resume.getUuid()));
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        if (checkNotExistInStorage(searchKey)) {
            addResume(resume, searchKey);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        removeResume(checkExistence(uuid));
    }

    @Override
    public Resume get(String uuid) {
        return getResume(checkExistence(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getListOfResume();
        list.sort(Comparator.comparing(Resume::getFullName));
        return list;
    }

    @Override
    public int compare(Resume o1, Resume o2) {
        int a = o1.getFullName().compareTo(o2.getFullName());
        int b = o1.getUuid().compareTo(o2.getUuid());
        if (a >= 0) {
            return b;
        } else {
            return a;
        }
    }

    private Object checkExistence(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (checkNotExistInStorage(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}