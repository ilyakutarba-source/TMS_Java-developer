import java.util.Scanner;

/**
 * @author Ilya
 * @date 08.03.2026
 */
//Задача *. Напишите программу, где пользователь вводит любое целое положительное число. А
//программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
//числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
//ввести некорректные данные
public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            System.out.print("Введите целое положительное число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) break;
                else System.out.println("Ошибка: число должно быть положительным!");
            } else {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
        }
        long sum = 0;
        System.out.print("Вычисление: ");
        for (int i = 1; i <= number; i++) {
            sum += i;
            if (i == number) System.out.print(i + " = ");
            else System.out.print(i + " + ");
        }
        System.out.println(sum);
        scanner.close();
    }
}
