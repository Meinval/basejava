package model;

import java.util.Objects;

public abstract class AbstractSection implements Section {
    Object content;

    public AbstractSection(Object content) {
        this.content = content;
    }

    @Override
    public abstract void print();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSection that = (AbstractSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
