import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        ArrayList<Product> products = Store.loadProducts();

        while (true) {
            System.out.println("\nWelcome to MiniMarket");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                if (Store.login(u, p)) {
                    System.out.println("Login successful!");
                    boolean loggedIn = true;
                    while (loggedIn) {
                        System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        switch (opt) {
                            case 1:
                                for (Product prod : products) {
                                    System.out.println(prod.getId() + ". " + prod.getName() + " - $" + prod.getPrice());
                                }
                                break;
                            case 2:
                                System.out.print("Enter product ID to add: ");
                                int pid = sc.nextInt();
                                for (Product prod : products) {
                                    if (prod.getId() == pid) cart.addItem(prod);
                                }
                                break;
                            case 3:
                                cart.viewCart();
                                break;
                            case 4:
                                cart.checkout();
                                break;
                            case 5:
                                loggedIn = false;
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else if (choice == 2) {
                System.out.print("Choose Username: ");
                String u = sc.nextLine();
                System.out.print("Choose Password: ");
                String p = sc.nextLine();
                if (Store.register(u, p))
                    System.out.println("Registered successfully!");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
