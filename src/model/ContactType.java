package model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackovelflow"),
    HOMEPAGE("Домашняя страница");

    ContactType(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }
}