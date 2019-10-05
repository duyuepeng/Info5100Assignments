package A4_5100.Q1;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius){
        super("Circle", 2*Math.PI*radius, Math.PI*Math.pow(radius,2));
        this.radius = radius;
    }
}
