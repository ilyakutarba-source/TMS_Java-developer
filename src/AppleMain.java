import java.lang.reflect.Field;

/**
 * @author Ilya
 * @date 29.03.2026
 */

public class AppleMain {
    public static void main(String[] args) throws Exception {
        Apple apple = new Apple();
        //получаем поле color
        Field field = Apple.class.getDeclaredField("color");
        //отключаем проверку доступа
        field.setAccessible(true);
        //меняем значение
        field.set(apple, "Green");
        System.out.println(field.get(apple));
    }
}
