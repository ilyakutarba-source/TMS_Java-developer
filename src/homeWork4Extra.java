/**
 * @author Ilya
 * @date 15.03.2026
 */
import java.util.Arrays;
import java.util.Scanner;


public class homeWork4Extra {

    public static int[] plusOne(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }

            arr[i] = 0;
        }

        int[] newArr = new int[arr.length + 1];
        newArr[0] = 1;

        return newArr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Введите элементы массива (цифры 0-9):");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        arr = plusOne(arr);

        System.out.println("Результат:");
        System.out.println(Arrays.toString(arr));

    }
}
// Сам бы решить не смог, но вроде разобрался с пятого раза..
