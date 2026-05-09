package CourseWork.util;

public final class AccountValidator {
    private static final String ACCOUNT_NUMBER_REGEX = "\\d{5}-\\d{5}";

    /**
     * Запрещает создавать объект utility-класса.
     */
    private AccountValidator() {
    }

    /**
     * Проверяет формат номера счета: пять цифр, дефис, пять цифр.
     */
    public static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches(ACCOUNT_NUMBER_REGEX);
    }
}
