package basejava.storage;

import basejava.strategy.ObjectSerializeStrategy;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectSerializeStrategy()) {
        });
    }
}
