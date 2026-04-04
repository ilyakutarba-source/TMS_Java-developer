/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork11;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        String shortest = s1;
        String longest = s1;

        if (s2.length() < shortest.length()) shortest = s2;
        if (s3.length() < shortest.length()) shortest = s3;

        if (s2.length() > longest.length()) longest = s2;
        if (s3.length() > longest.length()) longest = s3;

        System.out.println("Короткая: " + shortest + " (" + shortest.length() + ")");
        System.out.println("Длинная: " + longest + " (" + longest.length() + ")");
    }
}
