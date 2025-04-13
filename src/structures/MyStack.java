package structures;
import list.MyArrayList;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
