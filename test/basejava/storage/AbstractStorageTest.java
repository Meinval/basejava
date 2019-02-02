package basejava.storage;

import basejava.ResumeTestData;
import basejava.exception.ExistStorageException;
import basejava.exception.NotExistStorageException;
import basejava.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("C:\\projects");
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume resume1 = ResumeTestData.getTestData(UUID_1, "Иванов Иван Иванович");
    protected static final Resume resume2 = ResumeTestData.getTestData(UUID_2, "Петров Петр Петрович");
    protected static final Resume resume3 = ResumeTestData.getTestData(UUID_3, "Александров Александр Александрович");
    protected static final Resume resume4 = ResumeTestData.getTestData(UUID_4, "Дмитриев Дмитрий Дмитриевич");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_3, "Олегов Олег Олегович");
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        resume4.setFullName("Киселев Кисель Киселевич");
        storage.update(resume4);
    }

    @Test
    public void getAllSorted() throws Exception {
        assertEquals(3, storage.size());
        List<Resume> expectedStorage = Arrays.asList(resume3, resume1, resume2);
        assertEquals(expectedStorage, storage.getAllSorted());
    }

    @Test
    public void get() throws Exception {
        assertEquals(resume2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test
    public void save() throws Exception {
        storage.save(resume4);
        assertEquals(4, storage.size());
        assertEquals(resume4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() throws Exception {
        storage.save(resume3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_4);
    }
}