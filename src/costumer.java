import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Costumer {
    private Cart itemsCart;
    private int costumerBalance;

    /**
     * Constructor for Costumer
     */
    public Costumer(int costumerBalance)
    {
        itemsCart = new Cart();
        this.costumerBalance = costumerBalance;
    }
    /**
     * addToCart - a function to add element in the cart
     */
    public void addToCart(Products product, int quantity)
    {
        itemsCart.addItem(product, quantity);
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
        if (!trueProcess()) {
            throw new IllegalStateException("Insufficient balance or cart is invalid.");
        }

        List<Shippable> itemsToShip = new ArrayList<>();
        for (Map.Entry<Products, Integer> entry : itemsCart.getItems().entrySet()) {
            Products product = entry.getKey();
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
        for (Map.Entry<Products, Integer> entry : itemsCart.getItems().entrySet()) {
            Products product = entry.getKey();
            int quantity = entry.getValue();
            int price = product.getPrice() * quantity;
            System.out.printf("%dx %s\t%d\n", quantity, product.getName(), price);
            total += price;
        }
        printCheckoutReceipt(total, itemsToShip);
    }
    /**
     * trueProcess - just checks if the costumer can buy
     * return: true ? if balance can : false
     */
    private boolean trueProcess()
    {
        // Return false if the cart is empty
        if (itemsCart.getItems().isEmpty()) {
            return false;
        }
        return itemsCart.getTotalPrice() <= costumerBalance;
    }
    /**
     * printCheckoutReceipt - to print the product and the price just to make checkout more clean
     * @param total is the total price
     * @param itemsToShip is the list of shippable items
     */
    private void printCheckoutReceipt(int total, List<Shippable> itemsToShip )
    {
        int shippingFees = itemsToShip.isEmpty() ? 0 : 30;
        int totalPaid = total + shippingFees;
        costumerBalance -= totalPaid;

        System.out.printf("Subtotal\t%d\n", total);
        System.out.printf("Shipping\t%d\n", shippingFees);
        System.out.printf("Amount\t\t%d\n", totalPaid);
        System.out.printf("Remaining Balance\t%d\n", costumerBalance);
    }
}