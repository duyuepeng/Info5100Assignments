package A4_5100.Q3;

public class Cookie extends DessertItem {
    private int number;
    private int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public int getCost() {
        return (int) Math.round(this.pricePerDozen * this.number / 12.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DessertShop.formatName(
                this.number + " @ "
                        + DessertShop.cents2dollarsAndCents(this.pricePerDozen)
                        + "/dz.", 5.0 / 7));
        sb.append("\n");
        sb.append(DessertShop.formatName(this.getName(), 5.0 / 7));

        return sb.toString();
    }
}
