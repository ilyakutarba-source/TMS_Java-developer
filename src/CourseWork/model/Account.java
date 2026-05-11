package CourseWork.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private final String number;
    private BigDecimal balance;

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Списывает указанную сумму со счета.
     */
    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    /**
     * Пополняет счет на указанную сумму.
     */
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    /**
     * Сравнивает счета по номеру счета.
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Account)) {
            return false;
        }
        Account account = (Account) object;
        return Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
