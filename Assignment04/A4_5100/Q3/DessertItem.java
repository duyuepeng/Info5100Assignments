package A4_5100.Q3;

public abstract class DessertItem {
    protected String name;

    public DessertItem() {
        this("");
    }

    public DessertItem(String name) {
        if (name.length() > DessertShop.ITEM_NAME_MAX_SIZE)
            throw new IllegalArgumentException("Desert name length must be no more than " + DessertShop.ITEM_NAME_MAX_SIZE);
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public abstract int getCost();
}
