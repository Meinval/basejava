package basejava.storage;

import basejava.exception.ExistStorageException;
import basejava.exception.NotExistStorageException;
import basejava.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage, Comparator<Resume> {
    //    protected final Logger LOG = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    private Comparator<Resume> RESUME_COMPARATOR = (Resume o1, Resume o2) -> compare(o1, o2);

    public abstract List<Resume> doCopyAll();

    protected abstract SK getSearchKey(String uuid);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        doUpdate(resume, getExistedSearchKey(resume.getUuid()));
    }

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        doSave(resume, getNotExistedSearchKey(resume.getUuid()));
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        doDelete(getExistedSearchKey(uuid));
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return doGet(getExistedSearchKey(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        list.sort(RESUME_COMPARATOR);
        return list;
    }

    @Override
    public int compare(Resume o1, Resume o2) {
        return (o1.getFullName().compareTo(o2.getFullName()) >= 0) ? o1.getUuid().compareTo(o2.getUuid()) : o1.getFullName().compareTo(o2.getFullName());
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }
}