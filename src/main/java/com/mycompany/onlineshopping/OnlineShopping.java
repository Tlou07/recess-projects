/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.onlineshopping;

/**
 *
 * @author Matuma
 */ 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


// Cart item class
class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

// Shopping cart class
class ShoppingCart {
    List<CartItem> items = new ArrayList<>();

    void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.product.id == product.id) {
                item.quantity += quantity;
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("\nYour cart:");
        for (CartItem item : items) {
            System.out.printf("%s x%d - R%.2f\n", item.product.name, item.quantity, item.getTotal());
            total += item.getTotal();
        }
        System.out.printf("Total: R%.2f\n", total);
    }

    void checkout() {
        viewCart();
        items.clear();
        System.out.println("Thank you for your purchase!");
    }
}
public class OnlineShopping {
    static List<Product> products = new ArrayList<>();
    static ShoppingCart cart = new ShoppingCart();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample products
        products.add(new Product(1, "Laptop", 7000.00));
        products.add(new Product(2, "Headphones", 199.99));
        products.add(new Product(3, "Smartphone", 2000.00));
        products.add(new Product(4, "smartwatch", 150.00));
        int choice;
        do {
            System.out.println("\nWelcome to the Tshegofatso's Online Shop!");
            System.out.println("1. View Products");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> cart.viewCart();
                case 3 -> cart.checkout();
                case 4 -> System.out.println("Thank you for viewing our online shop");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }

    static void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.printf("%d. %s - R%.2f\n", p.id, p.name, p.price);
        }

        System.out.print("Enter product ID to add to cart (0 to go back): ");
        int id = scanner.nextInt();
        if (id == 0) return;

        Product selectedProduct = null;
        for (Product p : products) {
            if (p.id == id) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Invalid product ID.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        cart.addProduct(selectedProduct, qty);
        System.out.println("Added to cart.");





    }
}
