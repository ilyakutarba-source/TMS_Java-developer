/**
 * @author Ilya
 * @date 06.05.2026
 */
package HomeWork16;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(pairs(new String[]{"code", "bug"}));
        System.out.println(pairs(new String[]{"man", "moon", "main"}));
        System.out.println(pairs(new String[]{"man", "moon", "good", "night"}));
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String s : strings) {
            String first = s.substring(0, 1);
            String last = s.substring(s.length() - 1);
            map.put(first, last);
        }

        return map;
    }
}