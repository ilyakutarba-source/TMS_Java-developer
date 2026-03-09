import java.util.Scanner;

/**
 * @author Ilya
 * @date 08.03.2026
 */
// Задача №1. Напишите программу, которая будет принимать на вход число из консоли и на выход
//будет выводить сообщение четное число или нет. Для определения четности числа
//используйте операцию получения остатка от деления (операция выглядит так: '% 2')
public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Число " + number + " Чётное");
        } else {
            System.out.println("Число " + number + " Нечётное");

        }

    }
}
