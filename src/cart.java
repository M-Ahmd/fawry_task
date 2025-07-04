import java.util.HashMap;
import java.util.Map;

public class cart {
    private Map<products, Integer> items;
    /**
     * constructor for init the cart
     */
    public cart()
    {
        items = new HashMap<>();
    }
    /**
     * add_item - is a function to add products to cart
     * and update the total price
     * @param item is the products
     * @param quantity is the number of items
     */
    public void add_item(products item, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        else if(item.get_quantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity available.");
        } else if(item.isExpired()) {
            throw new IllegalArgumentException("Cannot add expired product: " + item.get_name() + ". Expired on: " + item.get_time_expire());
        } else {
            items.merge(item, quantity, Integer::sum);
        }
    }
    /**
     * get_total_price - function to get price
     * return: get the total price
     */
    public int get_total_price() {
        int total = 0;
        for (Map.Entry<products, Integer> entry : items.entrySet()) {
            total += entry.getKey().get_price() * entry.getValue();
        }
        return total;
    }
    /**
     * get_items - is a function to get 
     * map of the items and their quantities
     * return: Map of products to quantities
     */
    public Map<products, Integer> get_items()
    {
        return items;
    }
}
