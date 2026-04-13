/**
 * @author Ilya
 * @date 13.04.2026
 */
package HomeWork12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String text = "Contact me: teachmeskills@gmail.com, doc: 1423-1512-51, phone: +(29)1234567";
        findEmails(text);
        findDocuments(text);
        findPhones(text);
    }
    public static void findEmails(String text) {
        Pattern pattern = Pattern.compile("[\\w._%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("email: " + matcher.group());
        }
    }

    public static void findDocuments(String text) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{2}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("document number: " + matcher.group());
        }
    }

    public static void findPhones(String text) {
        Pattern pattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("phone: " + matcher.group());
        }
    }
}
