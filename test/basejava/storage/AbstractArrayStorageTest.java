package basejava.storage;

import basejava.exception.OverflowStorageException;
import basejava.model.Resume;
import org.junit.Test;

import static basejava.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
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
            fail("Overflow basejava.exception not happen");
        }
        storage.save(resume4);
    }
}
