//import java.util.*;
import java.time.LocalDate;
public class main {
    public static void main(String[] args){
        products p = new products("Product1", 100, 2);
        p.set_will_it_expire(true);
        p.set_time_expire(LocalDate.of(2024, 12, 31));
        p.set_is_shipping(true);
        p.set_weight(1.5);
        System.out.println("Product Name: " + p.get_name());
        System.out.println("Product Price: " + p.get_price());
        System.out.println("Product Quantity: " + p.get_quantity());
        System.out.println("Product Expiration Date: " + p.get_time_expire());
        System.out.println("Product Weight: " + p.get_weight());
    }
}
