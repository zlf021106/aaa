package ch5;

public  class Rectangle extends Shape {
    private double x, y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getArea() {
        return x * y;
    }

    public double getPerimeter() {
        return 2 * (x + y);
    }
}