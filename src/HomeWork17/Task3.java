/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork17;

import java.util.Scanner;
import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в формате \"100 BYN\": ");
        String input = scanner.nextLine();

        System.out.print("Введите курс доллара: ");
        double rate = scanner.nextDouble();

        Function<String, Double> convertToDollar = value -> {
            double byn = Double.parseDouble(value.split(" ")[0]);
            return byn / rate;
        };

        double result = convertToDollar.apply(input);
        System.out.println("Сумма в долларах: " + result);
    }
}