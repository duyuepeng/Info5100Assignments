package A4_5100.Q3;

public class Sundae extends IceCream {
    private String topping;
    private int toppingPrice;

    public Sundae(String name, int cost, String topping, int toppingPrice) {
        super(name, cost);
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public int getCost() {
        return super.getCost() + this.toppingPrice;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DessertShop.formatName(this.topping + " Sundae with " + this.getName(), 5.0 / 7));

        return sb.toString();
    }
}
