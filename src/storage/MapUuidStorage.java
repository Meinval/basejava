package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage implements Storage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public List<Resume> getListOfResume() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Object getSearchKey(String fullName) {
        return fullName;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getSearchKey(resume.getFullName());
        if (!checkNotExistInStorage(searchKey)) {
            updateResume(resume, searchKey);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void save(Resume resume) {
        String resumeUuid = resume.getFullName();
        Object searchKey = getSearchKey(resumeUuid);
        if (checkNotExistInStorage(searchKey)) {
            addResume(resume, searchKey);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.replace(resume.getFullName(), resume);
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        storage.put(resume.getFullName(), resume);
    }

    @Override
    protected void removeResume(Object searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected boolean checkNotExistInStorage(Object searchKey) {
        return Objects.isNull(storage.get(searchKey));
    }
}
