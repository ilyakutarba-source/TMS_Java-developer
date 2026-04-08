/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork9;

public class Rabbit extends Animal {
    @Override
    public void voice() {
        System.out.println("Кролик молчит или тихо пищит");
    }
    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("Grass")) {
            System.out.println("Кролик любит есть травку");
        } else {
            System.out.println("Кролик недоволен: " + food);
        }
    }
}
