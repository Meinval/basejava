package model;

import java.util.ArrayList;

public class MarkedListSection extends AbstractSection {
    private static final String MARK = "● ";

    public MarkedListSection(SectionType sectionType, Object content) {
        super(sectionType, content);
    }

    @Override
    public void print() {
        super.print();
        for (String string : (ArrayList<String>) content) {
            System.out.print(MARK);
            System.out.println(string);
        }
    }
}
