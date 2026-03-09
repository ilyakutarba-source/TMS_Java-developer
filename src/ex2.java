import java.util.Scanner;

/**
 * @author Ilya
 * @date 08.03.2026
 */
//Задача №2. Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
//Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold»
public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите температуру на улице (t): ");
        double t = scanner.nextDouble();

        if (t > -5) {
            System.out.println("Warm");
        } else if (t > -20) {
            System.out.println("Normal");
        } else {
            System.out.println("Cold");
        }
    }
}
