/**
 * @author Ilya
 * @date 26.04.2026
 */
package HomeWork15;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через запятую:");
        String input = scanner.nextLine();

        String[] arr = input.split(",");

        Set<Integer> newSet = new LinkedHashSet<>();

        for (String s : arr) {
            try {
                int num = Integer.parseInt(s.trim());
                newSet.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + s + "' не является числом");
            }
        }

        System.out.println("Результат: " + newSet);
    }
}