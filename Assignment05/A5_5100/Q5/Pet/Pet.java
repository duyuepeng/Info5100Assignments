package A5_5100.Q5.Pet;


public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sex;
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        switch (this.sex) {
            case MALE:
                return "MALE";
            case FEMALE:
                return "FEMALE";
            case SPAYED:
                return "SPAYED";
            case NEUTERED:
                return "NEUTERED";
            default:
                throw new IllegalStateException("Pet sex can not be " + this.sex);
        }
    }

    public void setSex(int sexid) {
        if (sex < 0 || sex >= 4) {
            throw new IllegalArgumentException("Pet sex can not be " + sexid);
        }
        this.sex = sexid;
    }

    @Override
    public String toString() {
        return this.getName() + " owned by " + this.getOwnerName() +
                " \nColor: " + this.getColor() +
                " \nSex: " + this.getSex();
    }
}
