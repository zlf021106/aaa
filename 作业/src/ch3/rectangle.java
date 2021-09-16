package ch3;

public class rectangle {
    double x, y;//x,y分别为长方形的长和宽
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getArea() {
        return x * y;
    }
    public double getPerimeter() {
        return 2 * (x + y);
    }
}