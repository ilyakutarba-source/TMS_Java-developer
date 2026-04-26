/**
 * @author Ilya
 * @date 26.04.2026
 */
package HomeWork15;

public class Task2Main {
    public static void main(String[] args) {
        Task2AnimalStorage storage = new Task2AnimalStorage();
        storage.addAnimal("Tiger");
        storage.addAnimal("Lion");
        storage.addAnimal("Elephant");
        System.out.println("После добавления :");
        storage.printAnimals();
        storage.removeAnimal();
        System.out.println("После удаления :");
        storage.printAnimals();
    }
}
