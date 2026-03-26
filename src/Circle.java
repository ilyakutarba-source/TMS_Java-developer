/**
 * @author Ilya
 * @date 24.03.2026
 */

public class Circle extends  Figure{

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
