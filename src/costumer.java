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
        if(!true_process())
            throw new IllegalStateException("Insufficient balance to complete the purchase.");
        else
        {
            double total_weight = 0;
            System.out.println("** Shipment notice ** ");
            for (Map.Entry<products, Integer> entry : items_cart.get_items().entrySet()) {
                products product = entry.getKey();
                int quantity = entry.getValue();
                if (product.isShippable()) {
                    print_shipment_notice(product, quantity);
                    total_weight += product.get_weight() * quantity;
                }
            }
            System.out.println("Total package weight " + total_weight);
            
            System.out.println("** Checkout receipt ** ");
            for (Map.Entry<products, Integer> entry : items_cart.get_items().entrySet()) {
                products product = entry.getKey();
                int quantity = entry.getValue();
                print_checkout_receipt(product, quantity);
            }
            System.out.println("Total price is " + items_cart.get_total_price());
        }
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
     * print_Shipment_notice - to print the product
     * and the quantity just to make checkout more clean
     * @param product is the product costumer will take
     * @param quantity is the number of quantities
     */
    private void print_shipment_notice(products product, int quantity)
    {
        
        System.out.println(
            quantity + "x " + product.get_name() + "\t"
            + product.get_weight() * quantity
        );
    }
    /**
     * print_checkout_receipt - to print the product
     * and the price just to make checkout more clean
     * @param product is the product costumer will take
     * @param quantity is the number of quantities
     */
    private void print_checkout_receipt(products product, int quantity)
    {
        
        System.out.println(
            quantity + "x " + product.get_name() + "\t"
            + product.get_price() * quantity
        );
    }
}