import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private int quantity;
    private final boolean willItExpire;
    private final LocalDate timeExpire;
    private final Shippable shipping;

    public Product(String name, int price, int quantity, boolean willItExpire, LocalDate timeExpire, Shippable shipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.willItExpire = willItExpire;
        this.timeExpire = timeExpire;
        this.shipping = shipping;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }

    public boolean isExpired() {
        return willItExpire && timeExpire != null && LocalDate.now().isAfter(timeExpire);
    }

    public boolean isShippable() {
        return shipping != null && shipping.isShippable();
    }

    public double getWeight() {
        if (!isShippable()) throw new IllegalStateException("Product is not shippable.");
        return shipping.getWeight();
    }

    public LocalDate getTimeExpire() {
        return timeExpire;
    }

    public Shippable getShipping() {
        return shipping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product other)) return false;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}