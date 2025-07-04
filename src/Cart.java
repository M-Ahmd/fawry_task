import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Products, Integer> items;
    /**
     * Constructor for initializing the cart
     */
    public Cart()
    {
        items = new HashMap<>();
    }
    /**
     * addItem - is a function to add products to cart
     * and update the total price
     * @param item is the Products
     * @param quantity is the number of items
     */
    public void addItem(Products item, int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        else if(item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity available.");
        } else if(item.isExpired()) {
            throw new IllegalArgumentException("Cannot add expired product: " + item.getName() + ". Expired on: " + item.getTimeExpire());
        } else {
            items.merge(item, quantity, Integer::sum);
        }
    }
    /**
     * getTotalPrice - function to get price
     * return: get the total price
     */
    public int getTotalPrice() {
        int total = 0;
        for (Map.Entry<Products, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
    /**
     * getItems - is a function to get 
     * map of the items and their quantities
     * return: Map of Products to quantities
     */
    public Map<Products, Integer> getItems()
    {
        return items;
    }
}
