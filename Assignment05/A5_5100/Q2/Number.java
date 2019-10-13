package A5_5100.Q2;

import java.util.Random;

public class Number {

    public void count(int a, int b) {
        try {
            System.out.println("The quotient of " + a + " and " + b + " is " + a / b);
        } catch (java.lang.ArithmeticException e) {
            System.out.println("The second number can not be 0");
        }
    }

    public static void main(String[] arg) {
        Number number = new Number();
        for (int i = 0; i < 50; i++) {
            number.count(new Random().nextInt(10),
                    new Random().nextInt(10));
        }
    }

}
