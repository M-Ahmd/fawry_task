import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = ProductFactory.createExpiringShippable("Cheese", 50, 10, LocalDate.now().plusDays(5), 0.5);
        Product expiredMilk = ProductFactory.createExpiringShippable("Milk", 30, 5, LocalDate.now().minusDays(2), 1.0);
        Product tv = ProductFactory.createNonExpiringShippable("TV", 3000, 2, 10.0);
        Product ebook = ProductFactory.createDigitalProduct("EBook", 100, 100);

        Customer customer = new Customer(5000);

        customer.addToCart(cheese, 2);
        customer.addToCart(tv, 1);
        customer.addToCart(ebook, 3);

        try {
            customer.addToCart(expiredMilk, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        System.out.println("\n---- Performing Checkout ----\n");
        customer.checkout();
    }
}