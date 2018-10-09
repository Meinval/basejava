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
        updateResume(resume, checkResumeNotExistence(resume.getUuid()));
    }

    @Override
    public void save(Resume resume) {
        addResume(resume, checkResumeExistence(resume.getUuid()));
    }

    @Override
    public void delete(String uuid) {
        removeResume(checkResumeNotExistence(uuid));
    }

    @Override
    public Resume get(String uuid) {
        return getResume(checkResumeNotExistence(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getListOfResume();
        list.sort(this);
        return list;
    }

    @Override
    public int compare(Resume o1, Resume o2) {
        return (o1.getFullName().compareTo(o2.getFullName()) >= 0) ? o1.getUuid().compareTo(o2.getUuid()) : o1.getFullName().compareTo(o2.getFullName());
    }

    public Object checkResumeNotExistence(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (checkNotExistInStorage(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }

    public Object checkResumeExistence(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!checkNotExistInStorage(searchKey)) {
            throw new ExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}