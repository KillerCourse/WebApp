package com.epam.redball.entity;

public class LanguageEntity extends BaseEntity {
    public static final String NAME_COLUMN = "name";
    public static final String SHORT_NAME_COLUMN = "short_name";

        private String name;
    private String shortName;

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
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", short_name='" + shortName + '\'' +
                '}';
    }
}
