/**
 * @author Ilya
 * @date 22.03.2026
 */

public class CreditCard {
    String accountNumber;
    double balance;

    //конструктор(пишу для себя, чтобы легче было потом понимать код)
    public CreditCard(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
        //пополнение
        public void deposit(double amount) {
            balance += amount;
        }

        //снятие
        public void withdraw(double amount) {
            balance -= amount;
        }

        //информация
        public void printInfo() {
            System.out.println("Номер счета: " + accountNumber +
                    ", Баланс: " + balance);
        }
    }

