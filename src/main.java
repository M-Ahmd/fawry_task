//import java.util.*;
import java.time.LocalDate;
public class main {
    public static void main(String[] args){
        products p = new products("Product1", 100, 2);
        cart c1 = new cart();
        p.set_will_it_expire(true);
        p.set_time_expire(LocalDate.of(2024, 12, 31));
        p.set_is_shipping(true);
        p.set_weight(1.5);
        c1.add_item(p, 2);
        System.out.println(c1.get_total_price());
    }
}
