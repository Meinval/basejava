package model;

import java.util.List;

public class TextListSection {
    private SectionType sectionType;
    private List<ResumeRow> textArray;

    public TextListSection(SectionType sectionType, List<ResumeRow> textArray) {
        this.sectionType = sectionType;
        this.textArray = textArray;
    }

    public TextListSection(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public List<ResumeRow> getTextArray() {
        return textArray;
    }

    public void setTextArray(List<ResumeRow> textArray) {
        this.textArray = textArray;
    }
}
