package com.redball.entity;

public class CartEntity extends Entity {

    public static final String USER_ID_COLUMN = "user_id";

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + getId() +
                ", user_id=" + userId +
                '}';
    }
}
