package com.epam.redball.entity;

public class OrderEntryEntity extends BaseEntity {
    public static final String ORDER_ID_COLUMN = "order_id";
    public static final String PRODUCT_ID_COLUMN = "product_id";
    public static final String QUANTITY_COLUMN = "quantity";
    public static final String PRICE_COLUMN = "price";

    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderEntryEntity{" +
                "id=" + getId() +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
