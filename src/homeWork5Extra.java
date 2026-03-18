/**
 * @author Ilya
 * @date 18.03.2026
 */

import java.util.Scanner;

public class homeWork5Extra {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество строк (n): ");
        int n = sc.nextInt();

        System.out.print("Введите количество столбцов (m): ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        int num = 0;

        // Заполнение змейкой
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                // слева направо
                for (int j = 0; j < m; j++) {
                    arr[i][j] = num++;
                }
            } else {
                // справа налево
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = num++;
                }
            }
        }

        System.out.println("\nРезультат:");

        // Вывод
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
