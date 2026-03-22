/**
 * @author Ilya
 * @date 12.03.2026
 */

public class Main {
    public static void main(String[] args) {
    //создаем 3 карточки
        CreditCard card1 = new CreditCard("1111", 100);
        CreditCard card2 = new CreditCard("2222", 200);
        CreditCard card3 = new CreditCard("3333", 300);

        //операции
        card1.deposit(50);
        card2.deposit(100);
        card3.deposit(70);

        //вывод
        card1.printInfo();
        card2.printInfo();
        card3.printInfo();
    }
}