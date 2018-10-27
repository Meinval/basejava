package model;

public class TextSection {
    private SectionType sectionType;
    private String text;

    public TextSection(SectionType sectionType, String text) {
        this.sectionType = sectionType;
        this.text = text;
    }

    public TextSection(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
