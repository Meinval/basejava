package model;

public interface Section<T> {

    void update(SectionType sectionType, T content);

    void print();


}
