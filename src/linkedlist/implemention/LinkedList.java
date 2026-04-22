package linkedlist.implemention;

public class LinkedList {

    // head node
    private Node head;
    private int size;

    private static class Node {
        private int data;
        private Node next;

        Node(int value) {
            this.data = value;
        }
    }

    public int size() {
        return size;
    }

    // add at first
    public void addFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        size++;
    }

    // add at last
    public void addAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        size++;
    }

    // print list
    public void printData() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        System.out.println("null");
    }

    // get element at index
    public void getElementAtParticularIndex(int index) {

        Node temp = head;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index fall apart..");
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        System.out.println(temp.data);
    }

    // search element
    public void serachItem(Integer item) {

        Node curr = head;

        while (curr != null) {
            if (curr.data == item) {
                System.out.println(item + " exist..");
                return;
            }
            curr = curr.next;
        }

        System.out.println("Doesn't exist..");
    }

    // delete node
    public void deleteNodeOnElement(int data) {

        Node temp = head;

        if (head == null) {
            throw new RuntimeException("Nothing is there to delete");
        }

        if (head.data == data) {
            System.err.println("Item deleted : " + head.data);
            head = head.next;
            size--;
            return;
        }

        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next != null) {
            System.err.println("Item deleted : " + temp.next.data);
            temp.next = temp.next.next;
            size--;
        }
    }

    // reverse (incomplete in your code)
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addAtLast(21);
        list.addAtLast(22);
        list.addAtLast(23);
        list.addAtLast(23);
        list.addAtLast(24);
        list.addAtLast(25);
        list.addAtLast(26);

        list.printData(); // print elements
        System.out.println();

        list.serachItem(24); // search element
        System.out.println();

        System.err.println("size : " + list.size()); // size
        System.out.println();

        list.getElementAtParticularIndex(6); // get by index
        System.out.println();

        list.deleteNodeOnElement(22); // delete element
        System.out.println("After delete element..");

        list.printData(); // print again
        System.out.println();
    }
}