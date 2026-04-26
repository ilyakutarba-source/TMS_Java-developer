/**
 * @author Ilya
 * @date 26.04.2026
 */
package HomeWork15;

import java.util.LinkedList;

public class Task2AnimalStorage {
    private LinkedList<String> animals;
    public Task2AnimalStorage() {
        animals = new LinkedList<>();
    }
    public void addAnimal(String name) {
        animals.addFirst(name);
    }
    public void removeAnimal() {
        if(!animals.isEmpty()) {
            animals.removeLast();
        } else {
            System.out.println("Список пуст");
        }
    }
    public void printAnimals() {
        System.out.println(animals);
    }
}
