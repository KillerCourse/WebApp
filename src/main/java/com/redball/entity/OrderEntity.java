package com.redball.entity;

import java.util.Date;

public class OrderEntity {
    public static final String ID_COLUMN = "id";
    public static final String USER_ID_COLUMN = "user_id";
    public static final String CREATION_DATE_COLUMN = "creation_date";
    public static final String ORDER_STATUS_COLUMN = "order_status";

    private int id;
    private int userId;
    private Date creationDate;
    private int orderStatus;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
