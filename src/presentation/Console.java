package presentation;

//import model.Character;
import model.Character;
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
        System.out.println("12. Filter characters by region");
        System.out.println("13. Filter characters by product bought from a specific universe");
        System.out.println("14. Sort products for a specific character ascending or descending");
        choice = Integer.parseInt(System.console().readLine());
        String name, universe;
        double price;
        int id;
        Character character;
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


            case 6:
                System.out.println("Please enter the name of the character: ");
                name = System.console().readLine();
                System.out.println("Please enter the region of the character: ");
                String ort = System.console().readLine();
                service.addCharacter(name, ort);
                showMenu();

            case 7:
                System.out.println("Please enter the id of the character: ");
                id = Integer.parseInt(System.console().readLine());
                character = service.getCharacter(id);
                System.out.println(character);
                showMenu();

            case 8:
                System.out.println("Please enter the id of the character: ");
                id = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the name of the character: ");
                name = System.console().readLine();
                System.out.println("Please enter the region of the character: ");
                ort = System.console().readLine();
                service.updateCharacter(id, name, ort);
                showMenu();
            case 9:
                System.out.println("Please enter the id of the character: ");
                id = Integer.parseInt(System.console().readLine());
                service.deleteCharacter(id);
                showMenu();
            case 10:
                List<model.Character> characters = new ArrayList<>();
                characters = service.getAllCharacter();
                for(Character character1 : characters)
                {
                    System.out.println(character1);
                }
                showMenu();

            case 11:
                System.out.println("Please enter the id of the character: ");
                int characterId = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter the id of the product: ");
                int productId = Integer.parseInt(System.console().readLine());
                service.orderProduct(characterId,productId);
                showMenu();

            case 12:
                System.out.println("Please enter the location:");
                String location = System.console().readLine();
                characters = service.filterByRegion(location);
                for(Character character1 : characters)
                {
                    System.out.println(character1);
                }
                showMenu();


            case 13:
                System.out.println("Enter the universe");
                universe = System.console().readLine();
                characters = service.filterCharactersByProductUniverse(universe);
                for(Character character1 : characters)
                {
                    System.out.println(character1);
                }
                showMenu();


            case 14:
                System.out.println("Please enter the id of the character: ");
                characterId = Integer.parseInt(System.console().readLine());
                System.out.println("Please enter 1 for ascending or 2 for descending order ");
                int mode = Integer.parseInt(System.console().readLine());
                products = service.sortProductsByPriceForCharacter(characterId, mode);
                System.out.println(products);
                showMenu();

        }
    }
}