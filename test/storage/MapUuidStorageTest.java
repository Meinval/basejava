package storage;

import model.Resume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapUuidStorageTest extends AbstractStorageTest {
    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume("uuid5", "Александров Александр Александрович");
        storage.update(resume);
        assertEquals(resume, storage.get("Александров Александр Александрович"));
    }

    @Test
    public void get() throws Exception {
        assertEquals(resume2, storage.get("Петров Петр Петрович"));
    }

    @Test
    public void save() throws Exception {
        storage.save(resume4);
        assertEquals(4, storage.size());
        assertEquals(resume4, storage.get("Киселев Кисель Киселевич"));
    }
}
