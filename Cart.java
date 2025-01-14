public class Cart {

    Product[] cartProducts = {};
    int quantity = 0;

    void addProduct (int id, int purchasedQuantity,  Shop shop) {

        for (Product product : shop.products) {
            if(product.id == id) {
                if(product.quantity < purchasedQuantity) {
                    System.out.println("La quantité demandée est supérieure à celle en stock. Achat impossible.");
                    return;
                }

                boolean added = false;

                for (Product cartProduct : cartProducts) {
                    if(cartProduct.id == id) {
                        cartProduct.quantity += purchasedQuantity;
                        added = true;
                    }
                }

                if(!added) {
                    Product[] newCartProducts = new Product[quantity + 1];

                    for(int i = 0; i < quantity; i++) {
                        newCartProducts[i] = cartProducts[i];
                    }

                    Product addedProduct = new Product(product.id, product.name, product.price, purchasedQuantity);
                    newCartProducts[quantity] = addedProduct;

                    cartProducts = newCartProducts;

                    quantity++;
                }

                product.quantity -= purchasedQuantity;

                System.out.println("Produit ajouté!");
                return;
            }
        }

        System.out.println("Aucun produit avec un tel id.");

    }

    public void listProducts() {
        if(cartProducts.length == 0) {
            System.out.println("Aucun produit dans le panier.");
            return;
        }

        for (Product product : cartProducts) {
            product.show();
        }
    }

    void deleteProduct(int id, Shop shop) {

        Product deletedProduct = null;

        Product[] newProducts = new Product[quantity - 1];

        // Supprimer le produit du panier
        int index = 0;

        for (Product product : cartProducts) {
            if (product.id == id) {
                deletedProduct = product;
                quantity--;
            }
            else {
                newProducts[index] = product;
                index++;
            }
        }

        cartProducts = newProducts;

        // Rajouter du stock dans le shop

        if(deletedProduct != null) {
            for (Product product : shop.products) {
                if (product.id == deletedProduct.id) {
                    product.quantity += deletedProduct.quantity;
                }
            }
        }

    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : cartProducts) {
            totalPrice += product.price * product.quantity;
        }
        return totalPrice;
    }

}
