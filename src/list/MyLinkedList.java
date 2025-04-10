package list;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class Node {
        T value;
        Node next;
        Node prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        Node node = new Node(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node curr = getNode(index);
            Node prevNode = curr.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = curr;
            curr.prev = newNode;
            size++;
        }
    }

    @Override
    public void set(int index, T item) {
        Node node = getNode(index);
        if (node != null) node.value = item;
    }

    @Override
    public T get(int index) {
        Node node = getNode(index);
        if (node != null) return node.value;
        return null;
    }

    @Override
    public T getFirst() {
        return head != null ? head.value : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.value : null;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        if (node != null) unlink(node);
    }

    @Override
    public void removeFirst() {
        if (head != null) unlink(head);
    }

    @Override
    public void removeLast() {
        if (tail != null) unlink(tail);
    }

    @Override
    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current.value = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public int indexOf(Object object) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if ((object == null && current.value == null) || (object != null && object.equals(current.value))) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node current = tail;
        int i = size - 1;
        while (current != null) {
            if ((object == null && current.value == null) || (object != null && object.equals(current.value))) {
                return i;
            }
            current = current.prev;
            i--;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        Object[] array = toArray();

        // Простой пузырьковый алгоритм
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        clear();
        for (Object obj : array) {
            addLast((T) obj);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) return null;

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) head = next;
        else prev.next = next;

        if (next == null) tail = prev;
        else next.prev = prev;

        size--;
    }
}
