package basejava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String url;
    private List<Position> positions;

    public Organization() {
    }

    public Organization(String name, String url, List<Position> positions) {
        this.name = name;
        this.url = url;
        this.positions = positions;
    }

    public Organization(String name, String url, Position... positions) {
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
        Organization organization = (Organization) o;
        return name.equals(organization.name) &&
                url.equals(organization.url) &&
                positions.equals(organization.positions);
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
