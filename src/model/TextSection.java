package model;

public class TextSection extends AbstractSection {

    public TextSection(Object content) {
        super(content);
    }

    @Override
    public void print() {
        System.out.println((String) content);
    }
}
