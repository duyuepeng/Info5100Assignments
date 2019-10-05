package A4_5100.Q3;

import java.util.Formatter;
import java.util.Vector;

public class Checkout {
    Vector<DessertItem> chart;

    public Checkout() {
        this.chart = new Vector<>();
    }

    public int numberOfItems() {
        return this.chart.size();
    }

    public void enterItem(DessertItem item) {
        this.chart.add(item);
    }

    public void clear() {
        this.chart.clear();
    }

    public int totalCost() {
        int sum = 0;
        for (DessertItem dessertItem : this.chart) {
            sum += dessertItem.getCost();
        }
        return sum;
    }

    public int totalTax() {
        return (int) Math.round(this.totalCost() * DessertShop.TAX_RATE);
    }

    private void centre(String s, StringBuilder sb) {
        sb.append(this.multiStr((DessertShop.COST_WIDTH - s.length()) / 2, " "));
        sb.append(s + "\n");
    }

    private String multiStr(int times, String str) {
        return new String(new char[times]).replace("\0", str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        String[] title = DessertShop.formatName(DessertShop.NAME, 1).split("\n");
        for (String s : title) {
            this.centre(s, sb);
        }

        String splitLine = this.multiStr(4 * (DessertShop.COST_WIDTH) / 7, "-");
        this.centre(splitLine, sb);
        formatter.format("%n");

        for (DessertItem item : this.chart) {
            String item_str = item.toString();
            formatter.format(
                    "%s%" + (DessertShop.COST_WIDTH - item_str.length() + item_str.lastIndexOf("\n") + 1) + "s%n",
                    item_str,
                    DessertShop.cents2dollarsAndCents(item.getCost()));
        }
        formatter.format("%n");
        formatter.format("Tax%"+(DessertShop.COST_WIDTH - 3)+"s%n", DessertShop.cents2dollarsAndCents(this.totalTax()));
        formatter.format("Total Cost%"+(DessertShop.COST_WIDTH - 10)+"s%n",
                DessertShop.cents2dollarsAndCents(this.totalCost() + this.totalTax()));
        return sb.toString();
    }
}
