package storage;

import model.Resume;

public interface Storage {

    void update(Resume r);

    void save(Resume r);

    void delete(String uuid);

    void clear();

    Resume[] getAll();

    Resume get(String uuid);

    int size();
}
