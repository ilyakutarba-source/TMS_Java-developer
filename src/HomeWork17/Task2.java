/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork17;

import java.util.Arrays;
import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        Integer[] numbers = {-5, 8, 0, 12, -3, 7};

        Predicate<Integer> isPositive = number -> number > 0;

        Arrays.stream(numbers)
                .filter(isPositive)
                .forEach(System.out::println);
    }
}