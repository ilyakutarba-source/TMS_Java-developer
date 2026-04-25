/**
 * @author Ilya
 * @date 20.04.2026
 */
package HomeWork13;

public class excExtra {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
