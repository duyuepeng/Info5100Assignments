package A5_5100.Q3;

public class FullTime extends Employee {

    public FullTime(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }


    @Override
    public int calculateSalary() {
        return this.getPaymentPerHour() * 8;
    }
}
