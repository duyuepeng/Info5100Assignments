package A4_5100.Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DessertShop {
    public static final String NAME = "M & M Dessert Shop";
    public static final double TAX_RATE = 0.065;
    public static final int ITEM_NAME_MAX_SIZE = 255;
    public static final int COST_WIDTH = 35;

    public static String cents2dollarsAndCents(int cents) {
        return (cents < 0 ? "-" : "") + (cents / 100 <= 0 ? " " : cents / 100) + "." + ((cents / 10) % 10) + cents % 10;
    }

    public static String formatName(String string, double percent) {
        String[] strings = string.split(" ");
        List temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int lineWordsLength = 0;
        for (String s : strings) {
            if (s.length() + lineWordsLength + temp.size() > DessertShop.COST_WIDTH * percent) {
                sb.append(String.join(" ", temp)).append("\n");
                temp.clear();
                lineWordsLength = 0;
            }
            temp.add(s);
            lineWordsLength += s.length();
        }
        sb.append(String.join(" ", temp));
        return sb.toString();
    }
}
