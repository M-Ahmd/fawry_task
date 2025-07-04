import java.time.LocalDate;

public class products {
    String name;
    int price;
    int quantity;
    boolean will_it_expire;
    LocalDate time_expire;
    boolean is_shipping;
    double weight;

    /** 
     * Constructor - to construct the complete product object
     * @param name Name of the product
     * @param price Price of the product
     * @param quantity Quantity of the product
     * @param will_it_expire Whether the product will expire
     * @param time_expire Expiration date of the product
     * @param is_shipping Whether the product is for shipping
     * @param weight Weight of the product
     */
    public products(String name, int price, int quantity, boolean will_it_expire, LocalDate time_expire, boolean is_shipping, double weight)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.will_it_expire = will_it_expire;
        this.time_expire = time_expire;
        this.is_shipping = is_shipping;
        this.weight = weight;
    }
    /* Constructor - to construct a partial product object */
    public products(String name, int price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.will_it_expire = false; // Default value
        this.time_expire = null; // Default value
        this.is_shipping = false; // Default value
        this.weight = 0.0; // Default value
    }
    /* Setter for price */
    public void set_price(int price)
    {
        this.price = price;
    }
    /* Setter for quantity */
    public void set_quantity(int quantity)
    {
        this.quantity = quantity;
    }
    /* Setter for expiration state */
    public void set_will_it_expire(boolean will_it_expire)
    {
        this.will_it_expire = will_it_expire;
    }
    /* Setter for expiration date */
    public void set_time_expire(LocalDate time_expire)
    {
        if(will_it_expire) {
            this.time_expire = time_expire;
        } else {
            throw new IllegalArgumentException("Cannot set expiration date if product does not expire.");
        }
    }
    /* Setter for shipping state */
    public void set_is_shipping(boolean is_shipping)
    {
        this.is_shipping = is_shipping;
    }
    /* Setter for weight */
    public void set_weight(double weight)
    {
        if(is_shipping) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Cannot set weight if product is not for shipping.");
        }
    }
    /* Getter for name */
    public String get_name()
    {
        return name;
    }
    /* Getter for price */
    public int get_price()
    {
        return price;
    }
    /* Getter for quantity */
    public int get_quantity()
    {
        return quantity;
    }
    /* Getter for expiration date */
    public LocalDate get_time_expire()
    {
        return time_expire;
    }
    /* Getter for weight */
    public double get_weight()
    {
        return weight;
    }
}