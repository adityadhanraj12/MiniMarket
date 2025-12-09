import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addItem(Product p) {
        items.add(p);
        System.out.println(p.getName() + " added to cart!");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        double total = 0;
        System.out.println("Your Cart:");
        for (Product p : items) {
            System.out.println("- " + p.getName() + " : $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            System.out.println("Checkout complete! Thank you for shopping.");
            items.clear();
        }
    }
}
