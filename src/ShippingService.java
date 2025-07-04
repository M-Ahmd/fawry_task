import java.util.List;

public class ShippingService {
    public static void shipItems(List<Shippable> itemsToShip) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : itemsToShip) {
            System.out.printf("%s\t%.0fg\n", item.get_name(), item.get_weight() * 1000);
            totalWeight += item.get_weight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}