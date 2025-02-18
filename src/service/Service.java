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


    }


    public void addProdukt(String name, int price, String universe) {
        int id= productRepository.getNextId();
        Product produkt= new Product(id,name, price, universe);
        productRepository.create(produkt);
    }

    public Product getProdukt(int id) {
        return productRepository.read(id);
    }

    public void updateProdukt(int id, String name, int price, String universe) {
        Product produkt = new Product(id, name, price, universe);
        productRepository.update(produkt);
    }

    public ArrayList<Product> getAllProdukts() {
        return (ArrayList<Product>) productRepository.getAll();
    }

    public void deleteProdukt(int id) {
        productRepository.delete(id);
    }


}
