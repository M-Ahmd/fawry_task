import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private final Cart cart = new Cart();
    private int balance;

    public Customer(int balance) {
        this.balance = balance;
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public void checkout() {
        if (!canPurchase())
            throw new IllegalStateException("Insufficient balance or empty cart.");

        List<Product> itemsToShip = new ArrayList<>();
        for (var entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            if (p.isShippable()) {
                for (int i = 0; i < qty; i++) itemsToShip.add(p);
            }
        }

        if (!itemsToShip.isEmpty()) {
            ShippingService.shipItems(itemsToShip);
        }

        System.out.println("** Checkout Receipt **");
        int subtotal = 0;
        for (var entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            int total = p.getPrice() * qty;
            System.out.printf("%dx %s\t%d\n", qty, p.getName(), total);
            subtotal += total;
        }

        int shipping = itemsToShip.isEmpty() ? 0 : 30;
        int totalPaid = subtotal + shipping;
        balance -= totalPaid;

        System.out.printf("Subtotal\t\t%d\n", subtotal);
        System.out.printf("Shipping Fee\t\t%d\n", shipping);
        System.out.printf("Total Paid\t\t%d\n", totalPaid);
        System.out.printf("Remaining Balance\t%d\n", balance);

        updateQuantities();
        cart.clear();
    }

    private boolean canPurchase() {
        return !cart.isEmpty() && cart.getTotalPrice() <= balance;
    }

    private void updateQuantities() {
        for (var entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            p.setQuantity(p.getQuantity() - qty);
        }
    }

    public int getBalance() {
        return balance;
    }
}