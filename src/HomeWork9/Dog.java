/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork9;

public class Dog extends Animal {
    @Override
    public void voice() {
        System.out.println("Собака говорит: Гав!");
    }
    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("Meat")) {
            System.out.println("Собака ест мясо");
        } else {
            System.out.println("Собака не любит " + food);
        }
    }
}
