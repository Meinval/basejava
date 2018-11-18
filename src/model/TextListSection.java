package model;

import java.util.List;
import java.util.Objects;

public class TextListSection extends AbstractSection {
    private List<String> lines;

    public TextListSection(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextListSection that = (TextListSection) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : lines) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
