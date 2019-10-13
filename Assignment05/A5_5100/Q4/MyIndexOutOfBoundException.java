package A5_5100.Q4;

import java.util.Random;

public class MyIndexOutOfBoundException extends IndexOutOfBoundsException {
    private final int lowerBound;
    private final int upperBound;
    private final int index;

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Error Message: " +
                "Index: " + index +
                ", but Lower bound: " + lowerBound +
                ", Upper bound: " + upperBound;
    }

    public static void main(String[] arg) {
        for (int i = 0; i < 10; i++) {
            try {
                int lowerBound = new Random().nextInt(10);
                int upperBound = new Random().nextInt(10) + lowerBound;
                int index = new Random().nextInt(10 + lowerBound * 2);
                if (index < lowerBound || index > upperBound) {
                    throw new MyIndexOutOfBoundException(lowerBound, upperBound, index);
                }
                System.out.println("Index: " + index +
                        ", Lower bound: " + lowerBound +
                        ", Upper bound: " + upperBound);

            } catch (MyIndexOutOfBoundException e) {
                System.out.println(e);
            }
        }
    }
}
