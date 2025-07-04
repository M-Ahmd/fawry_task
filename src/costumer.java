import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class costumer {
    private cart items_cart;
    private int costumer_balance;

    /**
     * constractor for constract the costumer
     */
    public costumer(int costumer_balance)
    {
        items_cart = new cart();
        this.costumer_balance = costumer_balance;
    }
    /**
     * add_to_cart - a function to add element
     * in the cart
     */
    public void add_to_cart(products product, int quantity)
    {
        items_cart.add_item(product, quantity);
    }
    
    /**
     * checkout - Processes the customer's cart for purchase.
     * <p>
     * This method checks if the customer has enough balance to complete the purchase.
     * If the balance is insufficient, it throws an IllegalStateException.
     * Otherwise, it prints a shipment notice (listing each product and its total weight),
     * calculates and displays the total package weight, then prints a checkout receipt
     * (listing each product and its total price), and finally displays the total price.
     *
     * Throws:
     *   IllegalStateException - if the customer's balance is less than the total cart price.
     */
    public void checkout()
    {
        if (!true_process()) {
            throw new IllegalStateException("Insufficient balance or cart is invalid.");
        }

    
        List<Shippable> itemsToShip = new ArrayList<>();
        for (Map.Entry<products, Integer> entry : items_cart.get_items().entrySet()) {
            products product = entry.getKey();
            int quantity = entry.getValue();
            if (product.isShippable()) {
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add(product);
                }
            }
        }
        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }

        System.out.println("** Checkout receipt **");
        int total = 0;
        for (Map.Entry<products, Integer> entry : items_cart.get_items().entrySet()) {
            products product = entry.getKey();
            int quantity = entry.getValue();
            int price = product.get_price() * quantity;
            System.out.printf("%dx %s\t%d\n", quantity, product.get_name(), price);
            total += price;
        }
        print_checkout_receipt(total, itemsToShip);
        
    }
    /**
     * true_process - just checks if the
     * costumer can buy
     * return: true ? if balance can : flase
     */
    private boolean true_process()
    {
        // Return false if the cart is empty
        if (items_cart.get_items().isEmpty()) {
            return false;
        }
        return items_cart.get_total_price() <= costumer_balance;
    }
    /**
     * print_checkout_receipt - to print the product
     * and the price just to make checkout more clean
     * @param product is the product costumer will take
     * @param quantity is the number of quantities
     */
    private void print_checkout_receipt(int total, List<Shippable> itemsToShip )
    {
        int shippingFees = itemsToShip.isEmpty() ? 0 : 30;
        int totalPaid = total + shippingFees;
        costumer_balance -= totalPaid;

        System.out.printf("Subtotal\t%d\n", total);
        System.out.printf("Shipping\t%d\n", shippingFees);
        System.out.printf("Amount\t\t%d\n", totalPaid);
        System.out.printf("Remaining Balance\t%d\n", costumer_balance);
    }
}