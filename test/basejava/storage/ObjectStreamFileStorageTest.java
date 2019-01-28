package basejava.storage;

import basejava.strategy.ObjectSerializeStrategy;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {

    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectSerializeStrategy()) {
        });
    }
}
