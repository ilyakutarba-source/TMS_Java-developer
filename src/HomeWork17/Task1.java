/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.print("Введите дату рождения в формате dd.MM.yyyy: ");
        String input = scanner.nextLine();

        LocalDate birthDate = LocalDate.parse(input, formatter);
        LocalDate hundredYearsDate = birthDate.plusYears(100);

        System.out.println("100 лет исполнится: " + hundredYearsDate.format(formatter));
    }
}