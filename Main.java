import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialiser une boutique et un panier

        Product[] myShopProducts = {
            new Product(1, "T-Shirt", 20, 50),
            new Product(2, "Jean", 40, 30),
            new Product(3, "Sneakers", 60, 20),
            new Product(4, "Casquette", 15, 40),
            new Product(5, "Montre", 120, 10),
            new Product(6, "Sac à dos", 35, 25),
            new Product(7, "Chaussettes", 5, 100),
            new Product(8, "Veste", 80, 15),
            new Product(9, "Écharpe", 10, 35),
            new Product(10, "Gants", 8, 50),
        };

        Shop myShop = new Shop(myShopProducts);

        Cart myCart = new Cart();

        // Créer une instance de Scanner pour lire les entrées

        Scanner sc = new Scanner(System.in);

        boolean shopping = true;

        while(shopping) {

            // Afficher le menu

            System.out.println("\nBienvenue dans la boutique en ligne. Veuillez choisir une des options suivantes en entrant le chiffre correspondant: ");
            System.out.println("1. Voir les produits de la boutique.");
            System.out.println("2. Acheter un produit.");
            System.out.println("3. Voir le contenu du panier.");
            System.out.println("4. Retirer un produit du panier.");
            System.out.println("5. Voir le prix total à payer.");
            System.out.println("6. Sortir de la boutique.\n");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myShop.listProducts();
                    break;
                case 2:
                    System.out.println("Veuillez préciser l'id du produit de la boutique à ajouter au panier.");
                    int id1 = sc.nextInt();

                    System.out.println("Veuillez préciser la quantité de ce produit à ajouter au panier.");
                    int qu = sc.nextInt();

                    myCart.addProduct(id1, qu, myShop);
                    break;
                case 3:
                    myCart.listProducts();
                    break;
                case 4:

                    if(myCart.quantity == 0) {
                        System.out.println("Aucun produit dans le panier.");
                        break;
                    }

                    System.out.println("Veuillez préciser l'id du produit du panier à retirer du panier.");

                    int id2 = sc.nextInt();
                    myCart.deleteProduct(id2, myShop);

                    System.out.println("Produit supprimé!");
                    break;
                case 5:
                    System.out.println("Le prix total à payer est: " + myCart.getTotalPrice() + " $.");
                    break;
                case 6:
                    shopping = false;
                    break;
                default:
                    System.out.println("Veuillez choisir une option valide.");
                    break;
            }

        };


    }

}
