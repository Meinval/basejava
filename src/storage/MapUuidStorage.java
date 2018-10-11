package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
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
    protected Object getSearchKey(String uuid) {
        for (Object o : storage.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if (((Resume) pair.getValue()).getUuid().equals(uuid)) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void addResume(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void removeResume(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected boolean checkNotExistInStorage(Object searchKey) {
        if (Objects.isNull(searchKey)) {
            return true;
        } else {
            return Objects.isNull(storage.get(((Resume) searchKey).getUuid()));
        }
    }
}
