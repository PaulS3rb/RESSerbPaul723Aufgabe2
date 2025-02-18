package presentation;

//import model.Character;
import model.Product;

import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private static Service service;


    public Console() {
        service = new Service();

    }

    public static void run() {

        showMenu();

    }

    private static void showMenu() {
        int choice;

        System.out.println("1. Add Product");
        System.out.println("2. Get a product");
        System.out.println("3. Update a product");
        System.out.println("4. Delete a product");
        System.out.println("5. Show all products");
        System.out.println("6. Add Character");
        System.out.println("7. Get a Character");
        System.out.println("8. Update a Character ");
        System.out.println("9. Delete a Character");
        System.out.println("10. Show all Characters");
        System.out.println("11. Buy a product");
        System.out.println("12. Filter characters by location");
        System.out.println("13. Filter characters by product bought from a specific universe");
        System.out.println("14. Sort products for a specific character ascending or descending");
        choice = Integer.parseInt(System.console().readLine());
        String name, universe;
        double price;
        int id;

        switch (choice) {
            case 1:
                System.out.println("Please enter the name of the product: ");
                name = System.console().readLine();
                System.out.println("Please enter the price of the product: ");
                price = Double.parseDouble(System.console().readLine());
                System.out.println("Please enter the universe of the product: ");
                universe = System.console().readLine();
                service.addProduct(name, price, universe);
                showMenu();

            case 2:
                System.out.println("Please enter the id of the product: ");
                id = Integer.parseInt(System.console().readLine());
                Product product = service.getProduct(id);
                System.out.println(product);
                showMenu();

            case 3:
                System.out.println("Please enter the id of the product: ");
                id = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the name of the product: ");
                name = System.console().readLine();
                System.out.println("Please enter the price of the product: ");
                price = Double.parseDouble(System.console().readLine());
                System.out.println("Please enter the universe: ");
                universe = System.console().readLine();
                service.updateProduct(id, name, price, universe);
                showMenu();


            case 4:
                System.out.println("Please enter the id of the product: ");
                id = Integer.parseInt(System.console().readLine());
                service.deleteProduct(id);
                showMenu();

            case 5:

                ArrayList<Product> products = new ArrayList<>();
                products = service.getAllProducts();
                for (Product product1 : products) {
                    System.out.println(product1);
                }
                showMenu();

        }
    }
}