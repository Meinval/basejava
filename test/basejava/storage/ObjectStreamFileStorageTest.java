package basejava.storage;

import basejava.storage.strategy.ObjectSerializeStrategy;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {

    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectSerializeStrategy()) {
        });
    }
}
