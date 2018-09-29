package storage;

import model.Resume;

public interface Storage {

    /**
     * Update resume if it founded, else error message
     *
     * @param r imputed resume to update
     */

    void update(Resume r);

    /**
     * Add resume to storage, increase storage size counter
     *
     * @param r imputed resume to save
     */

    void save(Resume r);

    /**
     * Remove resume from storage, decrease storage size counter
     *
     * @param uuid imputed id name
     */

    void delete(String uuid);

    /**
     * Clear storage. Also reset size counter
     */

    void clear();

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll();

    /**
     * @param uuid imputed id name
     * @return element of storage where id = uuid. If cant find, return null
     */

    Resume get(String uuid);

    /**
     * @return storage size counter
     */

    int size();
}
