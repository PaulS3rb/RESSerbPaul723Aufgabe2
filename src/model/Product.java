package model;

public class Product extends Entity {

    String name;
    double price;
    String universe;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", universe='" + universe + '\'' +
                '}';
    }

    public Product(int id, String name, double price, String universe) {
        super(id);
        this.name = name;
        this.price = price;
        this.universe = universe;
    }

    public Product(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }
}
