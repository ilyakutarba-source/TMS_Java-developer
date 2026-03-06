import java.util.Scanner;

/**
 * @author Ilya
 * @date 05.03.2026
 */

public class forVneBlokaCikla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        for (; i < 10; i++) {
            System.out.println(i);
            //действие которое выполняется в цикле. Если ввести 4, то посчитает
            // оставшееся кол-во цифр до 10(6), если ввести 9, то будет 9(одна цифра осталась до 10)
        }

    }
}
