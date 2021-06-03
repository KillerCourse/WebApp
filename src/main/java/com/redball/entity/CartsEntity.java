package com.redball.entity;

public class CartsEntity {
    public static final String ID_COLUMN = "id";
    public static final String USER_ID_COLUMN = "user_id";

    private int id;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                '}';
    }
}
