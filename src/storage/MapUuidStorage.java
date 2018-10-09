package storage;

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
        updateResume(resume, checkResumeNotExistence(resume.getFullName()));
    }

    @Override
    public void save(Resume resume) {
        addResume(resume, checkResumeExistence(resume.getFullName()));
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
