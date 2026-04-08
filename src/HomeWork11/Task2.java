/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        for (String s : arr) {
            System.out.println(s + " (" + s.length() + ")");
        }
    }
}
