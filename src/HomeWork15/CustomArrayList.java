package HomeWork15;

public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        elements = new Object[capacity];
    }

    public void add(T element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public boolean remove(T element) {
        int index = indexOf(element);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
        return true;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }

        Object[] newElements = new Object[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null && elements[i] == null) {
                return i;
            }

            if (element != null && element.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);

            if (i < size - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
