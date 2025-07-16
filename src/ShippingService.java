import java.util.List;

public class ShippingService {
    public static void shipItems(List<Product> items) {
        System.out.println("** Shipment Notice **");
        double total = 0;
        for (Product p : items) {
            System.out.printf("%s\t%.0fg\n", p.getName(), p.getWeight() * 1000);
            total += p.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", total);
    }
}