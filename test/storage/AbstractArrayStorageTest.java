package storage;

import exception.OverflowStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = OverflowStorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = storage.size(); i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + (i + "position")));
            }
        } catch (Exception e) {
            Assert.fail("Overflow exception not happen");
        }
        storage.save(resume4);
    }
}
