package basejava.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

import static basejava.util.DateUtil.of;

public class Position {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String title;
    private String text;

    public Position(int yearStart, Month mountStart, int yearEnd, Month monthEnd, String title, String text) {
        this.dateStart = of(yearStart, mountStart);
        this.dateEnd = of(yearEnd, monthEnd);
        this.title = title;
        this.text = text;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
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
        Position position = (Position) o;
        return dateStart.equals(position.dateStart) &&
                dateEnd.equals(position.dateEnd) &&
                title.equals(position.title) &&
                text.equals(position.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd, title, text);
    }

    @Override
    public String toString() {
        return dateStart + "\n" + dateEnd + "\n" + title + "\n" + text + "\n";
    }
}
