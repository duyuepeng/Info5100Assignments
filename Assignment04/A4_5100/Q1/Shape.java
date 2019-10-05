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

    private String formatDouble(double num) {
        String string = new DecimalFormat("#.00").format(num);
        if (string.charAt(string.length() - 1) == string.charAt(string.length() - 2)
                && string.charAt(string.length() - 1) == '0') {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public void getArea() {
        System.out.println(this.formatDouble(this.area));
    }

    public void getPerimeter() {
        System.out.println(this.formatDouble(this.perimeter));
    }
}