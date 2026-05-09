package CourseWork.service;

import CourseWork.exception.InvalidTransferException;
import CourseWork.model.TransferRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferParser {
    private static final Pattern ACCOUNT_PATTERN = Pattern.compile("\\b\\d{5}-\\d{5}\\b");
    private static final Pattern LABELED_AMOUNT_PATTERN = Pattern.compile(
            "(?i)(?:amount|sum|сумма)\\s*[:=\\-]?\\s*(-?\\d+(?:[.,]\\d+)?)");
    private static final Pattern AMOUNT_PATTERN = Pattern.compile("(?<![\\d-])-?\\d+(?:[.,]\\d+)?(?![\\d-])");

    /**
     * Извлекает из текста файла счет отправителя, счет получателя и сумму перевода.
     */
    public TransferRequest parse(String content) throws InvalidTransferException {
        List<String> accounts = findAccounts(content);
        if (accounts.size() < 2) {
            throw new InvalidTransferException("not enough valid account numbers");
        }

        BigDecimal amount = findAmount(content);
        return new TransferRequest(accounts.get(0), accounts.get(1), amount);
    }

    /**
     * Находит все номера счетов в формате XXXXX-XXXXX.
     */
    private List<String> findAccounts(String content) {
        List<String> accounts = new ArrayList<>();
        Matcher matcher = ACCOUNT_PATTERN.matcher(content);

        while (matcher.find()) {
            accounts.add(matcher.group());
        }

        return accounts;
    }

    /**
     * Ищет сумму перевода, сначала рядом с amount/sum/сумма, затем как первое отдельное число.
     */
    private BigDecimal findAmount(String content) throws InvalidTransferException {
        Matcher labeledAmountMatcher = LABELED_AMOUNT_PATTERN.matcher(content);
        if (labeledAmountMatcher.find()) {
            return parseAmount(labeledAmountMatcher.group(1));
        }

        String contentWithoutAccounts = ACCOUNT_PATTERN.matcher(content).replaceAll(" ");
        Matcher matcher = AMOUNT_PATTERN.matcher(contentWithoutAccounts);

        if (!matcher.find()) {
            throw new InvalidTransferException("transfer amount is missing");
        }

        return parseAmount(matcher.group());
    }

    /**
     * Преобразует найденную сумму в BigDecimal и поддерживает запятую как разделитель дробной части.
     */
    private BigDecimal parseAmount(String amount) throws InvalidTransferException {
        try {
            return new BigDecimal(amount.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new InvalidTransferException("invalid transfer amount");
        }
    }
}
