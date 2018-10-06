package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array sorted storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Resume::compareTo;

    @Override
    protected void addResumeToArray(Resume resume, int index) {
        int indexInStorage = -(index) - 1;
        System.arraycopy(storage, indexInStorage, storage, indexInStorage + 1, size - indexInStorage);
        storage[indexInStorage] = resume;
    }

    @Override
    protected void removeResumeFromArray(int index) {
        int lengthSegmentToMove = size - index - 1;
        if (lengthSegmentToMove != 0) {
            System.arraycopy(storage, index + 1, storage, index, lengthSegmentToMove);
        }
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
