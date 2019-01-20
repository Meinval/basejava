package basejava.exception;

public class OverflowStorageException extends StorageException {
    public OverflowStorageException(String uuid) {
        super("Storage overflow, cannot add resume " + uuid, uuid);
    }
}