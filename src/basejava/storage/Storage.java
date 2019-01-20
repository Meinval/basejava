package basejava.storage;

import basejava.model.Resume;

import java.util.List;

public interface Storage {

    void update(Resume resume);

    void save(Resume resume);

    void delete(String uuid);

    void clear();

    Resume get(String uuid);

    List<Resume> getAllSorted();

    int size();
}
