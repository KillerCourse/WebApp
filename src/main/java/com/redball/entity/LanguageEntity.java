package com.redball.entity;

public class LanguageEntity {
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String SHORT_NAME_COLUMN = "short_name";

    private int id;
    private String name;
    private String shortName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_name='" + shortName + '\'' +
                '}';
    }
}
