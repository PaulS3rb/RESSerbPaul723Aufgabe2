package service;

import model.Character;
import model.Product;
//import model.Character;
import repository.IRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
public class Service {


    private IRepository<Product> productRepository;
    private IRepository<Character> characterRepository;

    public Service()
    {
        this.productRepository =Repository.getInstance(Product.class);
        this.characterRepository =Repository.getInstance(Character.class);

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

        // Initialisierung der Charactere
        List<Character> charaktere = new ArrayList<>();
        Character c1 = new Character(1, "Thor", "Asgard");

        characterRepository.create(c1);
        this.orderProduct(1,1); // Mjolnir
        this.orderProduct(1,6); // Norn Stones
        this.orderProduct(1,10); // Darkhold

        Character c2 = new Character(2, "Black Panther", "Wakanda");
        characterRepository.create(c2);

        this.orderProduct(2,2); // Vibranium-Schild
        this.orderProduct(2,8); // X-Gene Serum
        Character c3 = new Character(3, "Iron Man", "Terra");
        characterRepository.create(c3);
        this.orderProduct(3,5); // Arc-Reaktor
        this.orderProduct(3,7); // Quantum Suit
        this.orderProduct(3,4); // Web-Shooter
        Character c4 = new Character(4, "Spider-Man", "Terra");
        characterRepository.create(c4);
        this.orderProduct(4,4); // Web-Shooter
        this.orderProduct(4,9); // Cosmic Cube
        Character c5 = new Character(5, "Doctor Strange", "Multiverse");
        characterRepository.create(c5);
        this.orderProduct(5,10); // Darkhold
        this.orderProduct(5,9); // Cosmic Cube
        this.orderProduct(5,3); // Infinity Gauntlet
//        charaktere.add(c1);
//        charaktere.add(c2);
//        charaktere.add(c3);
//        charaktere.add(c4);
//        charaktere.add(c5);

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

    public void addCharacter(String name, String region) {
        int id=characterRepository.getNextId();
        model.Character character=new model.Character(id, name, region);
        characterRepository.create(character);
    }

    public model.Character getCharacter(int id) {
        return characterRepository.read(id);
    }

    public void updateCharacter(int id, String name, String region) {
        model.Character character=new model.Character(id, name, region);
        characterRepository.update(character);
    }

    public void deleteCharacter(int id) {
        characterRepository.delete(id);
    }

    public List<Character> getAllCharacter() {
        return characterRepository.getAll();
    }

    public void orderProduct(int characterId, int productId) {
        Character character=characterRepository.read(characterId);
        ArrayList<Product> products = character.getProducts();
        Product product=productRepository.read(productId);
        products.add(product);
        character.setProducts(products);
        characterRepository.update(character);
    }


    /**
     * filters the Characters by their region
     * @param region, specifies the region of the characters
     * @return filteredCharacters, an array that contains the Characters from a specific region
     */
    public List<Character> filterByRegion(String region) {
        List<Character> filteredCharacters = new ArrayList<>();
        List<Character> characters = characterRepository.getAll();
        for (Character character : characters) {
            if (character.getRegion().equals(region)) {
                filteredCharacters.add(character);
            }
        }
        return filteredCharacters;
    }

    public List<Character> filterCharactersByProductUniverse(String universe) {

        List<Character> filteredCharacters = new ArrayList<>();
        List<Character> characters = characterRepository.getAll();
        List<Product> products = new ArrayList<>();
        for (Character character : characters) {
            products = character.getProducts();
            for(Product product : products){
                if(product.getUniverse().equals(universe)){
                    filteredCharacters.add(character);
                    break;
                }

            }
        }
        filteredCharacters.sort((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName()));
        return filteredCharacters;
    }


    /**
     * gets the products of a character and sorts them either ascending or descending by price
     * @param characterId, Id of the character
     * @param mode, the way you want to sort this array
     * @return products, an array that contains the products of a character sorted ascending or descending by price
     */
    public ArrayList<Product> sortProductsByPriceForCharacter(int characterId, int mode) {

        Character character = characterRepository.read(characterId);
        ArrayList<Product> products = character.getProducts();
        if(mode==1)
        {
            products.sort((p1,p2) -> (int) (p1.getPrice() - p2.getPrice()));
        }
        if(mode==2)
        {
            products.sort((p1,p2)-> (int) (p2.getPrice() - p1.getPrice()));
        }
        return products;
    }
}
