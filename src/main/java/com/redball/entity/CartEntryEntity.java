package com.redball.entity;

public class CartEntryEntity {
    public static final String ID_COLUMN = "id";
    public static final String CART_ID_COLUMN = "cart_id";
    public static final String PRODUCT_ID_COLUMN = "product_id";
    public static final String ORDERED_QUANTITY = "ordered_quantity";

    private int id;
    private int cartId;
    private int productId;
    private int orderedQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    @Override
    public String toString() {
        return "CartEntryEntity{" +
                "id=" + id +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", orderedQuantity=" + orderedQuantity +
                '}';
    }
}
