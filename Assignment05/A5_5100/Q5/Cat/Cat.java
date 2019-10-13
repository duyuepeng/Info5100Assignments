package A5_5100.Q5.Cat;

import A5_5100.Q5.Boardable.Boardable;
import A5_5100.Q5.Pet.Pet;

import java.util.Date;

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Date start;
    private Date end;

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return this.hairLength;
    }

    @Override
    public String toString() {
        return "CAT: \n" + super.toString() +
                " \nHair: " + this.getHairLength();
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
