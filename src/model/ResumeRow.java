package model;

public class ResumeRow {
    private String rowHeader;
    private String dateStart;
    private String dateEnd;
    private String boldText;
    private String text;
    private boolean needMark;

    public ResumeRow(String text) {
        this.text = text;
    }

    public ResumeRow(String text, boolean needMark) {
        this.text = text;
        this.needMark = needMark;
    }

    public ResumeRow(String rowHeader, String dateStart, String dateEnd, String boldText, String text, Boolean needMark) {
        this.rowHeader = rowHeader;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.boldText = boldText;
        this.text = text;
        this.needMark = needMark;
    }

    public ResumeRow(String rowHeader, String dateStart, String dateEnd, String boldText, Boolean needMark) {
        this.rowHeader = rowHeader;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.boldText = boldText;
        this.needMark = needMark;
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

    public boolean isNeedMark() {
        return needMark;
    }

    public void setNeedMark(boolean needMark) {
        this.needMark = needMark;
    }
}
