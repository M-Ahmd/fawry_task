import java.time.LocalDate;
public class main {
    public static void main(String[] args){
        // Create a costumer with a large balance
        costumer cost = new costumer(10000000);

        // Create 3 products using the full constructor
        products p1 = new products("Milk", 50, 10, true, LocalDate.of(2026, 1, 1), true, 1000);
        products p2 = new products("Bread", 20, 20, false, null, false, 20);
        products p3 = new products("Cheese", 80, 5, true, LocalDate.of(2026, 12, 31), true, 500);

        // Add products to the costumer's cart
        cost.add_to_cart(p1, 2);
        cost.add_to_cart(p2, 3);
        cost.add_to_cart(p3, 1);
        cost.checkout();
    }
}
