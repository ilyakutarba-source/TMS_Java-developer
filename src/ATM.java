/**
 * @author Ilya
 * @date 22.03.2026
 */

public class ATM {
    int count20;
    int count50;
    int count100;

    //конструктор
    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
    }

    //добавление денег
    public void addMoney(int add20, int add50, int add100) {
        count20 += add20;
        count50 += add50;
        count100 += add100;
    }

    // снятие денег
    public boolean withdraw(int amount) {
        int needed100 = Math.min(amount / 100, count100);
        amount -= needed100 * 100;
        int needed50 = Math.min(amount / 50, count50);
        amount -= needed50 * 50;
        int needed20 = Math.min(amount / 20, count20);
        amount -= needed20 * 20;
        // если не смогли выдать точно сумму
        if (amount != 0) {
            System.out.println("Невозможно выдать сумму");
            return false;
        }
        // уменьшаем количество купюр
        count100 -= needed100;
        count50 -= needed50;
        count20 -= needed20;

        // вывод
        System.out.println("Выдано:");
        System.out.println("100: " + needed100);
        System.out.println("50: " + needed50);
        System.out.println("20: " + needed20);

        return true;
    }
}
