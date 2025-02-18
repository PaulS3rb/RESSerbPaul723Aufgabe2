package model;

import java.util.ArrayList;

public class Character extends Entity{
    String name;
    String region;
    ArrayList<Product> products;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", products=" + products +
                '}';
    }

    public Character(int id, String name, String region) {
        super(id);
        this.name = name;
        this.region = region;
        this.products = new ArrayList<>();
    }

    public Character(int id, String name, String region, ArrayList<Product> products) {
        super(id);
        this.name = name;
        this.region = region;
        this.products = products;
    }

    public Character(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
