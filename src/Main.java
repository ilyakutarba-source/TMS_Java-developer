import java.util.Scanner;

/**
 * @author Ilya
 * @date 12.03.2026
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scannedString = sc.nextLine();

        if (scannedString.length() > 2) {
            System.out.println(scannedString.length());
            System.out.println(scannedString);
        } else {
            System.out.println("fail");
        }
    }
}