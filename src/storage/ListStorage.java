package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * List based storage for Resumes
 */

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size()]);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void deleteLastElement() {

    }

    @Override
    protected void increaseStorageSize() {

    }

    @Override
    protected void reduceStorageSize() {

    }

    @Override
    protected void checkOverflow(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    protected void addResume(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected void removeResume(String uuid, int index) {
        storage.remove(index);
    }

}
