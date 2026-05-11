/**
 * @author Ilya
 * @date 11.05.2026
 */
package HomeWork18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        // создаем Map
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Ivan");
        map.put(2, "Petr");
        map.put(3, "Alex");
        map.put(4, "Nikita");
        map.put(5, "Sergey");
        map.put(8, "Dima");
        map.put(9, "Oleg");
        map.put(13, "Maxim");


        // нужные id
        Set<Integer> ids = Set.of(1, 2, 5, 8, 9, 13);

        List<String> result = map.entrySet()
                .stream()

                // оставляем только нужные id
                .filter(entry -> ids.contains(entry.getKey()))

                // берем только имена
                .map(Map.Entry::getValue)

                // оставляем имена с нечетным количеством букв
                .filter(name -> name.length() % 2 != 0)

                // переворачиваем строки
                .map(name ->
                        new StringBuilder(name)
                                .reverse()
                                .toString()
                )

                .collect(Collectors.toList());

        System.out.println(result);
    }
}

