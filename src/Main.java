import list.MyArrayList;
import list.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing MyArrayList ===");
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        arrayList.addLast(10);
        arrayList.addLast(20);
        arrayList.addLast(30);
        System.out.println(arrayList);

        arrayList.add(1, 15);
        System.out.println(arrayList);

        arrayList.set(2, 99);
        System.out.println(arrayList);

        System.out.println(arrayList.get(1));
        System.out.println(arrayList.getLast());
        System.out.println(arrayList.size());

        arrayList.remove(1);
        System.out.println(arrayList);

        arrayList.removeLast();
        System.out.println(arrayList);

        System.out.println(arrayList.isEmpty());
        System.out.println();

        System.out.println("=== Testing MyLinkedList ===");
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.addLast("A");
        linkedList.addLast("B");
        linkedList.addLast("C");
        System.out.println(linkedList);

        linkedList.add(1, "X");
        System.out.println(linkedList);

        linkedList.set(2, "Y");
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.size());

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println(linkedList.isEmpty());
    }
}
