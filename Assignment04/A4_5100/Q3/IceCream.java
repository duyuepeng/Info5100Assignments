package A4_5100.Q3;

public class IceCream extends DessertItem {
    private int cost;

    IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DessertShop.formatName(this.getName(), 5.0 / 7));

        return sb.toString();
    }
}
