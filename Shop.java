public class Shop {

    Product[] products;

    Shop(Product[] table) {
        this.products = table;
    }

    public void listProducts() {
        if(products.length == 0) {
            System.out.println("Aucun produit dans la boutique.");
            return;
        }

        for (Product product : products) {
            product.show();
        }
    }

    public void retrieveQuantity(int id, int purchasedQuantity) {
        for (Product product : products) {
            if (product.id == id) {
                product.quantity = product.quantity - purchasedQuantity;
            }
        }
    }
}
