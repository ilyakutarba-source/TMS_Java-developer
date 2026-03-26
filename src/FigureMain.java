/**
 * @author Ilya
 * @date 24.03.2026
 */

public class FigureMain {
    public static void main(String[] args) {
        Figure[] figures = new Figure[5];
        figures[0] = new Rectangle(4, 5);
        figures[1] = new Circle(3);
        figures[2] = new Triangle(3,4,5);
        figures[3] = new Rectangle(2,6);
        figures[4] = new Circle(1);

        double totalPerimeter = 0;

        for (Figure figure : figures) {
            totalPerimeter += figure.getPerimeter();
        }
        System.out.println("Сумма периметров: " + totalPerimeter);
    }
}
