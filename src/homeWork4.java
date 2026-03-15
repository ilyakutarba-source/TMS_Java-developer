import java.util.Scanner;

/**
 * @author Ilya
 * @date 15.03.2026
 */

public class homeWork4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        // заполнение массива случайными числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        //        Пользователь вводит элементы
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("Введите элемент " + i + ": ");
//            arr[i] = scanner.nextInt();
        System.out.println("Вывод в прямом порядке: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // вывод в обратном порядке
        System.out.println("\nОбратный порядок:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        // Задача 2 — поиск min и max
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("\n" + "Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        // Задача 3 - Найти индексы минимального и максимального элементов и вывести в консоль.
        int minimal = arr[0];
        int maximum = arr[0];

        int minimalIndex = 0;
        int maximumIndex = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < minimal) {
                minimal = arr[i];
                minimalIndex = i;
            }

            if (arr[i] > maximum) {
                maximum = arr[i];
                maximumIndex = i;
            }
        }

        System.out.println("Минимальный элемент: " + minimal + " индекс: " + minimalIndex);
        System.out.println("Максимальный элемент: " + maximum + " индекс: " + maximumIndex);
        // Задача 4 -Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
        //сообщение, что их нет.
        System.out.println("Массив до изменения:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
        // разворот массива
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;

        }
        // вывод массива после изменения
        System.out.println("\nМассив после изменения:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Задача 6 - Проверить, является ли массив возрастающей последовательностью (каждое следующее
        //число больше предыдущего).
        boolean isIncreasing = true;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i - 1]) {
                isIncreasing = false;
                break;
            }
        }
        if(isIncreasing) {
            System.out.println("Массив является возрастающей последовательностью");
        } else {
            System.out.println("\nМассив НЕ является возрастающей последовательностью");
        }
    }
}
