package com.epam.redball.entity;


public class ProductEntity extends BaseEntity {
    public static final String DIAMETER_COLUMN = "diameter";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String QUANTITY_IN_STOCK_COLUMN = "quantity_in_stock";
    public static final String PRICE_PER_UNIT_COLUMN = "price_per_unit";
    public static final String NAME_COLUMN = "name";
    public static final String DESCRIPTION_COLUMN = "description";

    private double diameter;
    private double weight;
    private int quantity;
    private double price;
    private String name;
    private String description;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public void setPricePerUnit(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + getId() +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

