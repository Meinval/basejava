package basejava.storage;

import basejava.storage.strategy.ObjectSerializeStrategy;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectSerializeStrategy()) {
        });
    }
}
