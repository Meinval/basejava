package model;

import java.util.Objects;

public class Company {
    private String name;
    private String url;
    private String dateStart;
    private String dateEnd;
    private String title;
    private String text;

    public Company(String name, String url, String dateStart, String dateEnd, String title, String text) {
        this.name = name;
        this.url = url;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.title = title;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return Objects.equals(name, company.name) &&
                Objects.equals(url, company.url) &&
                Objects.equals(dateStart, company.dateStart) &&
                Objects.equals(dateEnd, company.dateEnd) &&
                Objects.equals(title, company.title) &&
                Objects.equals(text, company.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, dateStart, dateEnd, title, text);
    }

    @Override
    public String toString() {
        return name + "\n" + url + "\n" + dateStart + "\n" + dateEnd + "\n" + title + "\n" + text + "\n";
    }
}
