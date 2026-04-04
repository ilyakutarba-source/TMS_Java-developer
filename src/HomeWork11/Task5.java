/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i);
            result += input.charAt(i);
        }
        System.out.println(result);
    }
}
