/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork10;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // toString()
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', age=" + age + "}";
    }

    // equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // ссылка на тот же объект
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
