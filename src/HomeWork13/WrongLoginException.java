/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork13;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
