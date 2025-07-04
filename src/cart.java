import java.util.ArrayList;
import java.util.List;

public class cart {
    private List<products> items;
    private int total_price;
    public cart()
    {
        items = new ArrayList<>();
        total_price = 0;
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
        } else {
            items.add(item);
            total_price += item.get_price() * quantity;
        }
    }
    public int get_total_price()
    {
        return total_price;
    }
    
}
