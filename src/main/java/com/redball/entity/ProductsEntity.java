package com.redball.entity;


public class ProductsEntity {
    public static final String ID_COLUMN = "id";
    public static final String DIAMETER_COLUMN = "diameter";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String QUANTITY_IN_STOCK_COLUMN = "quantity_in_stock";
    public static final String PRICE_PER_UNIT_COLUMN = "price_per_unit";
    public static final String NAME_COLUMN = "name";
    public static final String DESCRIPTION_COLUMN = "description";

    private int id;
    private double diameter;
    private double weight;
    private int quantity;
    private double price;
    private String name;
    private String description;

    public ProductsEntity(int id, double diameter, double weight, int quantity, double price, String name, String description) {
        this.id = id;
        this.diameter = diameter;
        this.weight = weight;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.description= description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
                "id=" + id +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

