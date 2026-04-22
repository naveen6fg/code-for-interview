package com.corejavaconcept.comparator;

public class Product {

    int id;
    String name;
    double price;

    public Product(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.price = salary;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
