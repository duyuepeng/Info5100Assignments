package A4_5100.Q3;

public class Candy extends DessertItem {
    private double weight;
    private int pricePerPound;

    Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        return (int) Math.round(weight * pricePerPound);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DessertShop.formatName(DessertShop.cents2dollarsAndCents((int) Math.round(weight * 100)) + " " +
                "lbs. @ " + DessertShop.cents2dollarsAndCents(this.pricePerPound) + "/lb.", 5.0 / 7));
        sb.append("\n");
        sb.append(DessertShop.formatName(this.getName(), 5.0 / 7));

        return sb.toString();
    }
}
