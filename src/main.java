import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        // Create a costumer with a large balance
        Costumer cost = new Costumer(10000000);

        // Create 3 products using the full constructor
        Products p1 = new Products("Milk", 50, 10, true, LocalDate.of(2026, 1, 1), true, 1000);
        Products p2 = new Products("Bread", 20, 20, false, null, false, 20);
        Products p3 = new Products("Cheese", 80, 5, true, LocalDate.of(2026, 12, 31), true, 500);

        // Add products to the costumer's cart
        cost.addToCart(p1, 2);
        cost.addToCart(p2, 3);
        cost.addToCart(p3, 1);
        cost.checkout();
        System.out.println(p1.getQuantity());
    }
}
