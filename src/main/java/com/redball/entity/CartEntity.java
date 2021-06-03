package com.redball.entity;

public class CartEntity {
    public static final String ID_COLUMN = "id";
    public static final String USER_ID_COLUMN = "user_id";

    private int id;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", user_id=" + userId +
                '}';
    }
}
