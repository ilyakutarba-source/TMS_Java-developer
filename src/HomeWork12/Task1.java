/**
 * @author Ilya
 * @date 13.04.2026
 */
package HomeWork12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String text = "I love USA and NASA but not abc or A or ABCDEFG";

        Pattern pattern = Pattern.compile("\\b[A-Z]{2,6}\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
