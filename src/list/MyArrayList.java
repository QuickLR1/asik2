package list;
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>  {
    public Object[] elementData;
    public int size;
    private static final int DEFAULT_CAPACITY = 10 ;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
        size = 0;
    }
    // Это для проверки хватает ли место в массиве,если не хватает то добавляем.
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length){
            int newCapacity = elementData.length * 2;
            Object [] newElementData = new Object[newCapacity];

            for (int i = 0; i < size; i++){
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
        }
    }
    // Если выходим за пределы размеров,выдаем ошибку.
    private void checkIndex(int index) {
        if (index < 0 && index < size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    @Override
    public int size() {
        return size;
    }

    // Методы на добавление
    @Override
    public void add(T item){
        ensureCapacity(size + 1);
        elementData[size++] = item;
    }
    @Override
    public void add(int index, T item){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--){
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = item;
        size++;
    }
    @Override
    public void addFirst(T item){
        add(0,item);
    }
    @Override
    public void addLast(T item){
        add(item);
    }
    // геттеры
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }
    @Override
    public T getFirst(){
        return (T) elementData[0];
    }
    @Override
    public T getLast(){
        return (T) elementData[size - 1];

    }
    //ремуверы
    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size - 1; i++){
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
    }
    @Override
    public void removeFirst(){
        remove(0);
    }
    @Override
    public void removeLast(){
        remove(size - 1);
    }


    @Override
    public void set (int index, T item){
        checkIndex(index);
        elementData[index] = item;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                T a = (T) elementData[j];
                T b = (T) elementData[j + 1];
                if (a.compareTo(b) > 0) {
                    elementData[j] = b;
                    elementData[j + 1] = a;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elementData[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) throw new IllegalStateException("Больше нет эдементов.");
                return (T) elementData[cursor++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }




}
