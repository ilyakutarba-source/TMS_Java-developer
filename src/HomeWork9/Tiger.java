/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork9;

public class Tiger extends Animal {
    @Override
    public void voice() {
        System.out.println("Тигр рычит!");
    }
    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("Meat")) {
            System.out.println("Тигр ест мясо");
        } else {
            System.out.println("Тигр не ест" + food);
        }
    }
}
