package storage;

import exception.OverflowStorageException;
import model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;
import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = OverflowStorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = storage.size(); i < STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + (i + "position"), "fio" + (i + "position")));
            }
        } catch (Exception e) {
            fail("Overflow exception not happen");
        }
        storage.save(resume4);
    }
}
