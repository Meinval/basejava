import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.OverflowStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import storage.Storage;

public abstract class AbstractStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(new Resume(UUID_3));
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(new Resume(UUID_4), storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        storage.get(UUID_2);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = ExistStorageException.class)
    public void getAlreadyExist() throws Exception {
        storage.save(new Resume(UUID_3));
    }

    @Test(expected = OverflowStorageException.class)
    public void getStorageException() throws Exception {
        for (int i = 3; i < 10000; i++) {
            storage.save(new Resume("uuid" + (i + 1)));
        }
        storage.save(new Resume("uuid10001"));
    }
}