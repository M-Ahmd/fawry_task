import java.util.List;

public class ShippingService {
    /**
     * shipItems - Ships a list of shippable items.
     * <p>
     * This method prints a shipment notice for all items to be shipped, displaying each item's name and weight in grams.
     * It also calculates and prints the total package weight in kilograms.
     *
     * @param itemsToShip List of items implementing the Shippable interface to be shipped.
     */
    public static void shipItems(List<Shippable> itemsToShip) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : itemsToShip) {
            System.out.printf("%s\t%.0fg\n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}