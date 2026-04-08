/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextLine();
        }

        for (String word : arr) {
            boolean unique = true;

            for (int i = 0; i < word.length(); i++) {
                for (int j = i + 1; j < word.length(); j++) {
                    if (word.charAt(i) == word.charAt(j)) {
                        unique = false;
                        break;
                    }
                }
                if (!unique) break;
            }

            if (unique) {
                System.out.println("Первое слово с уникальными символами: " + word);
                return;
            }
        }
        System.out.println("Нет таких слов");
    }
}
