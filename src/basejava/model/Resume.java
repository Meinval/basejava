package basejava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final Resume EMPTY = new Resume();

    static {
        EMPTY.addSection(SectionType.OBJECTIVE, TextSection.EMPTY);
        EMPTY.addSection(SectionType.PERSONAL, TextSection.EMPTY);
        EMPTY.addSection(SectionType.ACHIEVEMENT, TextListSection.EMPTY);
        EMPTY.addSection(SectionType.QUALIFICATIONS, TextListSection.EMPTY);
        EMPTY.addSection(SectionType.EXPERIENCE, new OrganizationSection(Organization.EMPTY));
        EMPTY.addSection(SectionType.EDUCATION, new OrganizationSection(Organization.EMPTY));
    }

    // Unique identifier
    private String uuid;

    private String fullName;
    private Map<ContactType, String> contactsMap = new EnumMap<>(ContactType.class);
    private Map<SectionType, AbstractSection> sectionsMap = new EnumMap<>(SectionType.class);

    public Resume() {
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<ContactType, String> getContactsMap() {
        return contactsMap;
    }

    public void setContactsMap(Map<ContactType, String> contactsMap) {
        this.contactsMap = contactsMap;
    }

    public Map<SectionType, AbstractSection> getSectionsMap() {
        return sectionsMap;
    }

    public void setSectionsMap(Map<SectionType, AbstractSection> sectionsMap) {
        this.sectionsMap = sectionsMap;
    }

    public String getContact(ContactType type) {
        return contactsMap.get(type);
    }

    public AbstractSection getSection(SectionType type) {
        return sectionsMap.get(type);
    }

    public void addContact(ContactType type, String value) {
        contactsMap.put(type, value);
    }

    public void addSection(SectionType type, AbstractSection section) {
        sectionsMap.put(type, section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contactsMap, resume.contactsMap) &&
                Objects.equals(sectionsMap, resume.sectionsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contactsMap, sectionsMap);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(uuid).append("\n");
        sb.append(fullName).append("\n");
        for (Object o : contactsMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            sb.append(((ContactType) entry.getKey()).getTitle()).append(":").append(entry.getValue().toString()).append("\n");
        }
        for (Object o : sectionsMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            sb.append(((SectionType) entry.getKey()).getTitle()).append("\n").append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}
