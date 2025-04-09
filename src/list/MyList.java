package list;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> { // T это generic( типо универсальный тип данных,когда буду использовать буду обьявлять.), interface это что-то по типо шаблона.То есть те функции которые здесь,должны быть реализованы в любом классе.
    void add(T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);

    void set(int index, T item);

    T get(int index);
    T getFirst();
    T getLast();

    void remove(int index);
    void removeFirst();
    void removeLast();

    void sort();

    int indexOf(Object object);
    int lastIndexOf(Object object);

    boolean contains(Object object);

    Object[] toArray();
    void clear();
    int size();
    boolean isEmpty();

    @Override
    Iterator<T> iterator();
}
