package model;

import java.util.ArrayList;
import java.util.Objects;

public class TableListSection extends AbstractSection {

    public TableListSection(SectionType sectionType, Object content) {
        super(sectionType, content);
    }

    @Override
    public void print() {
        super.print();
        for (TableText tableText : (ArrayList<TableText>) content) {
            if (Objects.nonNull(tableText.getRowHeader())) {
                System.out.println(tableText.getRowHeader());
            }
            if (Objects.nonNull(tableText.getDateStart())) {
                System.out.println(tableText.getDateStart() + " - " + tableText.getDateEnd());
            }
            if (Objects.nonNull(tableText.getBoldText())) {
                System.out.println(tableText.getBoldText());
            }
            if (Objects.nonNull(tableText.getText())) {
                System.out.println(tableText.getText());
            }
        }
    }
}
