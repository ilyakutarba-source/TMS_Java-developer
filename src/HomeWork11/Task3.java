/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextLine();
        }

        int sum = 0;
        for (String s : arr) {
            sum += s.length();
        }

        double avg = sum / 3.0;

        System.out.println("Средняя длина: " + avg);

        for (String s : arr) {
            if (s.length() < avg) {
                System.out.println(s + " (" + s.length() + ")");
            }
        }
    }
}
