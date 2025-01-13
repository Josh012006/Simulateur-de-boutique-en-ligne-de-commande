public class Product {

    int id;
    String name;
    int price;
    int quantity;

    Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void show() {
        System.out.println("ID: " + id + "; Name: " + name + "; Price: " + price + " $; Quantity: " + quantity);
    }
}
