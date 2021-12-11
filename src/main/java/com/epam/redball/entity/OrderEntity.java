package com.epam.redball.entity;

import java.util.Date;

public class OrderEntity extends BaseEntity {
    public static final String USER_ID_COLUMN = "user_id";
    public static final String CREATION_DATE_COLUMN = "creation_date";
    public static final String ORDER_STATUS_COLUMN = "order_status";

    private int userId;
    private Date creationDate;
    private int orderStatus;

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
                "id=" + getId() +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
