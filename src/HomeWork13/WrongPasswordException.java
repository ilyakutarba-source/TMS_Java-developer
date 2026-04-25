/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork13;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
