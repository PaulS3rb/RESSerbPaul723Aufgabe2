package service;

import java.util.*;
import model.Product;
//import model.Character;
import repository.IRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Service {


    private IRepository<Product> productRepository;

    public Service()
    {
        this.productRepository =Repository.getInstance(Product.class);
        List<Product> produkte = new ArrayList<>();
        produkte.add(new Product(1,"Mjolnir", 500.0, "Asgard"));
        produkte.add(new Product(2,"Vibranium-Schild", 700.0, "Wakanda"));
        produkte.add(new Product(3,"Infinity Gauntlet", 10000.0, "Titan"));
        produkte.add(new Product(4,"Web-Shooter", 250.0, "Terra"));
        produkte.add(new Product(5,"Arc-Reaktor", 1500.0, "Terra"));
        produkte.add(new Product(6,"Norn Stones", 1200.0, "Asgard"));
        produkte.add(new Product(7,"Quantum Suit", 3000.0, "Terra"));
        produkte.add(new Product(8,"X-Gene Serum", 850.0, "X-Mansion"));
        produkte.add(new Product(9,"Cosmic Cube", 9000.0, "Multiverse"));
        produkte.add(new Product(10,"Darkhold", 2000.0, "Multiverse"));
        for(Product p : produkte)
        {
            productRepository.create(p);
        }

    }


    public void addProduct(String name, double price, String universe) {
        int id= productRepository.getNextId();
        Product produkt= new Product(id,name, price, universe);
        productRepository.create(produkt);
    }

    public Product getProduct(int id) {
        return productRepository.read(id);
    }

    public void updateProduct(int id, String name, double price, String universe) {
        Product produkt = new Product(id, name, price, universe);
        productRepository.update(produkt);
    }

    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) productRepository.getAll();
    }

    public void deleteProduct(int id) {
        productRepository.delete(id);
    }



}
