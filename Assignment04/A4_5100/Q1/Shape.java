package A4_5100.Q1;

import java.text.DecimalFormat;

public class Shape {
    private String name = "Shape";
    private double perimeter;
    private double area;

    public Shape() {
        this.perimeter = 0;
        this.area = 0;
    }

    public Shape(String name, double perimeter, double area) {
        this.name = name;
        this.perimeter = perimeter;
        this.area = area;
    }

    public void draw() {
        System.out.println("Drawing " + this.name);
    }

    public void getArea() {
        System.out.println(new DecimalFormat("#.00").format(this.area));
    }

    public void getPerimeter() {
        System.out.println(new DecimalFormat("#.00").format(this.perimeter));
    }
}