package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Company {
    private String name;
    private String url;
    private List<Position> positions;

    public Company(String name, String url, Position... positions) {
        this.name = name;
        this.url = url;
        this.positions = Arrays.asList(positions);
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

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name) &&
                url.equals(company.url) &&
                positions.equals(company.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, positions);
    }

    @Override
    public String toString() {
        return name + "\n" + url + "\n" + positions + "\n";
    }
}
