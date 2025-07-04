import java.time.LocalDate;

public class Products implements Shippable {
    private String name;
    private int price;
    private int quantity;
    private boolean willItExpire;
    private LocalDate timeExpire;
    private boolean isShipping;
    private double weight;

    /** 
     * Constructor - to construct the complete product object
     * @param name Name of the product
     * @param price Price of the product
     * @param quantity Quantity of the product
     * @param willItExpire Whether the product will expire
     * @param timeExpire Expiration date of the product
     * @param isShipping Whether the product is for shipping
     * @param weight Weight of the product
     */
    public Products(String name, int price, int quantity, boolean willItExpire, LocalDate timeExpire, boolean isShipping, double weight)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.willItExpire = willItExpire;
        this.timeExpire = timeExpire;
        this.isShipping = isShipping;
        this.weight = weight;
    }
    /* Constructor - to construct a partial product object */
    public Products(String name, int price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.willItExpire = false; // Default value
        this.timeExpire = null; // Default value
        this.isShipping = false; // Default value
        this.weight = 0.0; // Default value
    }
    /* Setter for price */
    public void setPrice(int price)
    {
        this.price = price;
    }
    /* Setter for quantity */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    /* Setter for expiration state */
    public void setWillItExpire(boolean willItExpire)
    {
        this.willItExpire = willItExpire;
    }
    /* Setter for expiration date */
    public void setTimeExpire(LocalDate timeExpire)
    {
        if(willItExpire) {
            this.timeExpire = timeExpire;
        } else {
            throw new IllegalArgumentException("Cannot set expiration date if product does not expire.");
        }
    }
    /* Setter for shipping state */
    public void setIsShipping(boolean isShipping)
    {
        this.isShipping = isShipping;
    }
    /* Setter for weight */
    public void setWeight(double weight)
    {
        if(isShipping) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Cannot set weight if product is not for shipping.");
        }
    }
    @Override
    public String getName()
    {
        return name;
    }
    /* Getter for price */
    public int getPrice()
    {
        return price;
    }
    /* Getter for quantity */
    public int getQuantity()
    {
        return quantity;
    }
    /* Getter for expiration date */
    public LocalDate getTimeExpire()
    {
        return timeExpire;
    }
    @Override
    public double getWeight()
    {
        if (!isShippable()) {
            throw new IllegalStateException("This product does not require shipping.");
        }
        return weight;
    }
    /**
     * Get the state of expire
     */
    public boolean getWillItExpire()
    {
        return willItExpire;
    }
    /**
     * Get the state of shipping
     */
    public boolean isShippable() {
        return isShipping;
    }
    /**
     * isExpired - tell us is it expired or not
     * return: true or false
     */
    public boolean isExpired() {
        return willItExpire && timeExpire != null && LocalDate.now().isAfter(timeExpire);
    }
}
