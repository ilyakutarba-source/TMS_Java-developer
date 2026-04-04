/**
 * @author Ilya
 * @date 04.04.2026
 */
package HomeWork9;

public class MainAnimal {
    public static void main(String[] args) {
        Animal rabbit = new Rabbit();
        rabbit.voice();
        rabbit.eat("Grass");
        rabbit.eat("Meat");

        Animal tiger = new Tiger();
        tiger.voice();
        tiger.eat("Meat");

        Animal dog = new Dog();
        dog.voice();
        dog.eat("Grass");
        dog.eat("Meat");
    }
}
