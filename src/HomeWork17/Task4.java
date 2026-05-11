/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork17;

import java.util.Scanner;
import java.util.function.Consumer;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в формате \"100 BYN\": ");
        String input = scanner.nextLine();

        System.out.print("Введите курс доллара: ");
        String rateInput = scanner.nextLine().replace(",", ".");
        double rate = Double.parseDouble(rateInput);

        Consumer<String> convertAndPrint = value -> {
            double byn = Double.parseDouble(value.split(" ")[0]);
            double usd = byn / rate;
            System.out.printf("Сумма в долларах: %.2f%n", usd);
        };

        convertAndPrint.accept(input);
    }
}