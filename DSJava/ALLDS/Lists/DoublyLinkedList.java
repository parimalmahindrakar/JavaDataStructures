
public class DoublyLinkedList {

    static class Node {

        int data;
        Node next = null;
        Node prev = null;

        Node(int data) {
            this.data = data;
        }
    }

    static int size = 0;
    static Node head = null;
    static Node tail = null;

    public static void add(Node node) {

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;

    }

    public static void addFirst(Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;

    }


    public static int elementAt(int index) {
        if (index > size) {
            return -1;
        }
        Node node = head;
        while (index - 1 != 0) {
            node = node.next;
            index--;
        }
        return node.data;
    }


    public static void print() {
        Node temp = head;
        System.out.print("Doubly LL : [ ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public static int getSize() {
        return size;
    }


    public static void main(String[] args) {

        add(new Node(12));
        add(new Node(23));
        add(new Node(65));
        addFirst(new Node(999));
        print();
        System.out.println("Size : " + getSize());
        System.out.println("Element at 2nd position : "+elementAt(2));
        // System.out.println(head.data);

    }





}