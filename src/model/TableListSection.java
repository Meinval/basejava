package model;

import java.util.ArrayList;
import java.util.Objects;

public class TableListSection extends AbstractSection {

    public TableListSection(ArrayList<RowText> content) {
        super(content);
    }

    @Override
    public void print() {
        for (RowText rowText : (ArrayList<RowText>) content) {
            if (Objects.nonNull(rowText.getRowHeader())) {
                System.out.println(rowText.getRowHeader());
            }
            if (Objects.nonNull(rowText.getDateStart())) {
                System.out.println(rowText.getDateStart() + " - " + rowText.getDateEnd());
            }
            if (Objects.nonNull(rowText.getBoldText())) {
                System.out.println(rowText.getBoldText());
            }
            if (Objects.nonNull(rowText.getText())) {
                System.out.println(rowText.getText());
            }
        }
    }
}
