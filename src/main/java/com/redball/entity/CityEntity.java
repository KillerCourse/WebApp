package com.redball.entity;

public class CityEntity extends Entity {
        public static final String NAME_COLUMN = "name";

    private String name;

      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
