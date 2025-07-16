public class ShippingBehavior implements Shippable {
    private final double weight;

    public ShippingBehavior(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}