/**
 * @author Ilya
 * @date 24.03.2026
 */

public class Rectangle extends Figure {
    double width;
    double height;
    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
