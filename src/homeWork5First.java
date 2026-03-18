import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ilya
 * @date 18.03.2026
 */

public class homeWork5First {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        // 1. Заполнение массива
        for(int i = 0; i <arr.length; i++) {
            for(int j = 0; j <arr[i].length; j++) {
                arr[i][j] = (int)(Math.random() * 10);
            }
        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.deepToString(arr));
        // 2. Ввод числа
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = sc.nextInt();
        int sum = 0;
        // 3. Прибавление + подсчет суммы
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] += num;
                sum += arr[i][j];
            }
        }
        System.out.println("Измененный массив:");
        System.out.println(Arrays.deepToString(arr));
        // 4. Сумма
        System.out.println("Сумма элементов: " + sum);
    }
}
