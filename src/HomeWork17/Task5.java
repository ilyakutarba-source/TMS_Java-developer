/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork17;

import java.util.Scanner;
import java.util.function.Supplier;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Supplier<String> reverseString = () -> {
            System.out.print("Введите строку: ");
            String text = scanner.nextLine();
            return new StringBuilder(text).reverse().toString();
        };

        System.out.println("Строка задом наперед: " + reverseString.get());
    }
}