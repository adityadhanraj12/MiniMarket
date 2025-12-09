import java.io.*;
import java.util.*;

public class Store {
    private static final String USER_FILE = "users.txt";
    private static final String PRODUCT_FILE = "products.txt";

    public static boolean register(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] creds = line.split(",");
                if (creds[0].equals(username) && creds[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                products.add(new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading products.");
        }
        return products;
    }
}
