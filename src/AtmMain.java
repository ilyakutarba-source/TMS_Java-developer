/**
 * @author Ilya
 * @date 23.03.2026
 */

public class AtmMain {
    public static void main(String[] args) {
        ATM atm = new ATM(10, 10, 10);

        atm.addMoney(2, 1, 0);

        boolean result = atm.withdraw(370);

        System.out.println("Успешно: " + result);
    }
}
