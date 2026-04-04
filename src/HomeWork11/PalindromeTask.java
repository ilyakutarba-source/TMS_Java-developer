/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;

import java.util.Scanner;

public class PalindromeTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку:");
        String input = sc.nextLine();

        //разбиваем строку на слова
        String[] words = input.split(" ");

        System.out.println("Введите номер слова:");
        int n = sc.nextInt();

        // проверка на ошибку
        if (n < 1 || n > words.length) {
            System.out.println("Ошибка! В строке только " + words.length + " слов.");
            return;
        }

        String word = words[n - 1];

        //проверка на палиндром
        boolean isPalindrome = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Слово \"" + word + "\" — палиндром");
        } else {
            System.out.println("Слово \"" + word + "\" — НЕ палиндром");
        }
    }
}
