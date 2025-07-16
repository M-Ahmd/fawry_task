import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product item, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        if (item.isExpired())
            throw new IllegalArgumentException("Expired product: " + item.getName());
        if (item.getQuantity() < quantity)
            throw new IllegalArgumentException("Insufficient quantity for " + item.getName());

        items.merge(item, quantity, Integer::sum);
    }

    public int getTotalPrice() {
        int total = 0;
        for (var entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}