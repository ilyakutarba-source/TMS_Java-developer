/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork10;

public class UserMain {
    public static void main(String[] args) {

        User user1 = new User(1, "John", 25);
        User user2 = new User(1, "John", 25);

        System.out.println(user1);
        System.out.println(user2);

        System.out.println("equals: " + user1.equals(user2));
    }
}
