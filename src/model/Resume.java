package model;

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
    private TextSection objectiveSection;
    private TextSection personalSection;
    private TextListSection achievementSection;
    private TextListSection qualificationsSection;
    private TextListSection experienceSection;
    private TextListSection educationSection;

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

    public TextSection getObjectiveSection() {
        return objectiveSection;
    }

    public void setObjectiveSection(TextSection objectiveSection) {
        this.objectiveSection = objectiveSection;
    }

    public TextSection getPersonalSection() {
        return personalSection;
    }

    public void setPersonalSection(TextSection personalSection) {
        this.personalSection = personalSection;
    }

    public TextListSection getAchievementSection() {
        return achievementSection;
    }

    public void setAchievementSection(TextListSection achievementSection) {
        this.achievementSection = achievementSection;
    }

    public TextListSection getQualificationsSection() {
        return qualificationsSection;
    }

    public void setQualificationsSection(TextListSection qualificationsSection) {
        this.qualificationsSection = qualificationsSection;
    }

    public TextListSection getExperienceSection() {
        return experienceSection;
    }

    public void setExperienceSection(TextListSection experienceSection) {
        this.experienceSection = experienceSection;
    }

    public TextListSection getEducationSection() {
        return educationSection;
    }

    public void setEducationSection(TextListSection educationSection) {
        this.educationSection = educationSection;
    }
}
