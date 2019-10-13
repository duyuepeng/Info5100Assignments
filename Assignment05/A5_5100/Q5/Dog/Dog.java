package A5_5100.Q5.Dog;

import A5_5100.Q5.Boardable.Boardable;
import A5_5100.Q5.Pet.Pet;

import java.util.Date;

public class Dog extends Pet implements Boardable {
    private String size;
    private Date start;
    private Date end;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "DOG: \n" + super.toString() +
                " \nSize: " + this.getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        this.start = new Date(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        this.end = new Date(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        if (this.start == null || this.end == null || this.start.after(this.end)) {
            return false;
        }
        Date date = new Date(year, month, day);
        return !(date.before(this.start) || date.after(this.end));
    }
}
