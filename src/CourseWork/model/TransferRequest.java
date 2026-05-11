package CourseWork.model;

import java.math.BigDecimal;

public class TransferRequest {
    private final String fromAccount;
    private final String toAccount;
    private final BigDecimal amount;

    public TransferRequest(String fromAccount, String toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public String toReportText() {
        return "transfer from " + fromAccount + " to " + toAccount + " " + amount.stripTrailingZeros().toPlainString();
    }
}
