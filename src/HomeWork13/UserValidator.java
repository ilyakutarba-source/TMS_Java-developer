/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork13;

public class UserValidator {
    public static boolean check(String login, String password, String confirmPassword)
        throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20 || login.contains(" ")) {
            throw new WrongLoginException("Логин должен быть меньше 20 символов и без пробелов");
        }
        if (password.length() >= 20 || password.contains(" ")) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов и без пробелов");
        }
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            throw new WrongPasswordException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли не совпадают");
        }
        return true;
    }
}
