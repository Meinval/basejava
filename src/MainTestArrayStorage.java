import model.Resume;
import storage.ArrayStorage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("Иванов Иван Иванович");
        resume1.setUuid("uuid1");
        Resume resume2 = new Resume("Петров Петр Петрович");
        resume2.setUuid("uuid2");
        Resume resume3 = new Resume("Александров Александр Александрович");
        resume3.setUuid("uuid3");
        Resume resumeToUpdate = new Resume("Дмитриев Дмитрий Дмитриевич");
        resumeToUpdate.setUuid("uuid2");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        ARRAY_STORAGE.update(resumeToUpdate);

        System.out.println("Get resume1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(resume);
        }
    }
}
