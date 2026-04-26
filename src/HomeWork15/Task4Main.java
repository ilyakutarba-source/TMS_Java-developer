package HomeWork15;

public class Task4Main {
    public static void main(String[] args) {
        CustomArrayList<Object> collection = new CustomArrayList<>(2);

        collection.add("Java");
        collection.add(15);
        collection.add(4.5);

        System.out.println("Collection after add: " + collection);
        System.out.println("Element at index 1: " + collection.get(1));
        System.out.println("Contains Java: " + collection.contains("Java"));
        System.out.println("Contains Python: " + collection.contains("Python"));

        collection.remove(15);
        System.out.println("Collection after remove: " + collection);

        collection.clear();
        System.out.println("Collection after clear: " + collection);
    }
}
