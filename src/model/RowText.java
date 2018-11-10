package model;

public class RowText {
    private String rowHeader;
    private String dateStart;
    private String dateEnd;
    private String boldText;
    private String text;

    public RowText(String text) {
        this.text = text;
    }

    public RowText(String rowHeader, String dateStart, String dateEnd, String boldText, String text) {
        this.rowHeader = rowHeader;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.boldText = boldText;
        this.text = text;
    }

    public RowText(String rowHeader, String dateStart, String dateEnd, String boldText) {
        this.rowHeader = rowHeader;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.boldText = boldText;
    }

    public String getRowHeader() {
        return rowHeader;
    }

    public void setRowHeader(String rowHeader) {
        this.rowHeader = rowHeader;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getBoldText() {
        return boldText;
    }

    public void setBoldText(String boldText) {
        this.boldText = boldText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
