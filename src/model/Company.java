package model;

import java.util.Objects;

public class Company {
    private String companyName;
    private String companyUrl;
    private String dateStart;
    private String dateEnd;
    private String title;
    private String text;

    public Company(String companyName, String companyUrl, String dateStart, String dateEnd, String title, String text) {
        this.companyName = companyName;
        this.companyUrl = companyUrl;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.title = title;
        this.text = text;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) &&
                Objects.equals(companyUrl, company.companyUrl) &&
                Objects.equals(dateStart, company.dateStart) &&
                Objects.equals(dateEnd, company.dateEnd) &&
                Objects.equals(title, company.title) &&
                Objects.equals(text, company.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, companyUrl, dateStart, dateEnd, title, text);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companyUrl='" + companyUrl + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
