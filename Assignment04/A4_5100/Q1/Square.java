package A4_5100.Q1;

public class Square extends Shape {
    private double side;

    public Square(double side){
        super("Square", 4*side, side*side);
        this.side = side;
    }
}
