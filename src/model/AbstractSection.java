package model;

public abstract class AbstractSection implements Section {
    private SectionType sectionType;
    Object content;

    public AbstractSection(SectionType sectionType, Object content) {
        this.sectionType = sectionType;
        this.content = content;
    }

    @Override
    public void update(SectionType sectionType, Object content) {
        this.sectionType = sectionType;
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(sectionType.getTitle());
    }
}
