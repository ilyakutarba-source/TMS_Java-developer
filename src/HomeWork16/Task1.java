package HomeWork16;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(wordMultiple(new String[]{"c", "c", "c", "c"}));
    }

    public static Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> result = new LinkedHashMap<>();

        for (String word : words) {
            result.put(word, result.containsKey(word));
        }

        return result;
    }
}
