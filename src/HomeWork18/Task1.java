/**
 * @author Ilya
 * @date 11.05.2026
 */
package HomeWork18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10));
        int sum = list.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .mapToInt(x -> x)
                .sum();

        System.out.println(sum);
    }
}
