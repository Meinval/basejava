package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;
    private String fullName;
    private ContractInfo contactInfoSection;
    private ArrayList<AbstractSection> linkedSectionList;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public ContractInfo getContactInfoSection() {
        return contactInfoSection;
    }

    public void setContactInfoSection(ContractInfo contactInfoSection) {
        this.contactInfoSection = contactInfoSection;
    }

    public ArrayList<AbstractSection> getLinkedSectionList() {
        return linkedSectionList;
    }

    public void setLinkedSectionList(ArrayList<AbstractSection> linkedSectionList) {
        this.linkedSectionList = linkedSectionList;
    }
}
