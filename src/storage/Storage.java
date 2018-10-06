package storage;

import model.Resume;

import java.util.List;

public interface Storage {

    void update(Resume r);

    void save(Resume r);

    void delete(String uuid);

    void clear();

    Resume get(String uuid);

    List<Resume> getAllSorted();

    int size();
}
