/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork13;

public class excMain {
    public static void main(String[] args) {
        try {
            boolean result = UserValidator.check(
                    "myLogin",
                    "pass123",
                    "pass123"
            );
            System.out.println("Все данные корректны: " +result);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля :" + e.getMessage());
        }
    }
}
