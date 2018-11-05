package model;

public class TextSection extends AbstractSection {

    public TextSection(SectionType sectionType, Object content) {
        super(sectionType, content);
    }

    @Override
    public void print() {
        super.print();
        System.out.println((String) content);
    }
}
