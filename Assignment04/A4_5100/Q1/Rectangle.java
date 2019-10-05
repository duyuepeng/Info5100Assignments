package A4_5100.Q1;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        super("Rectangle", 2 * (width + height), width * height);
        this.width = width;
        this.height = height;
    }
}
