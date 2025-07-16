import java.time.LocalDate;

public class ProductFactory {

    public static Product createExpiringShippable(String name, int price, int quantity, LocalDate expiry, double weight) {
        return new Product(name, price, quantity, true, expiry, new ShippingBehavior(weight));
    }

    public static Product createNonExpiringShippable(String name, int price, int quantity, double weight) {
        return new Product(name, price, quantity, false, null, new ShippingBehavior(weight));
    }

    public static Product createDigitalProduct(String name, int price, int quantity) {
        return new Product(name, price, quantity, false, null, null);
    }

    public static Product createExpiringNonShippable(String name, int price, int quantity, LocalDate expiry) {
        return new Product(name, price, quantity, true, expiry, null);
    }
}