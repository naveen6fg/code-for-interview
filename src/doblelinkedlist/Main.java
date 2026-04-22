package doblelinkedlist;

import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }

    // Helper method to print cache state
    public void printCache() {
        Node curr = head.next;
        System.out.print("Cache (MRU -> LRU): ");
        while (curr != tail) {
            System.out.print("[" + curr.key + "=" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        cache.printCache(); 
        // Expected: [3=30] [2=20] [1=10]

        System.out.println("Get 1: " + cache.get(1)); 
        // Access key 1 → becomes MRU

        cache.printCache(); 
        // Expected: [1=10] [3=30] [2=20]

        cache.put(4, 40); 
        // Evicts LRU → key 2

        cache.printCache(); 
        // Expected: [4=40] [1=10] [3=30]

        System.out.println("Get 2: " + cache.get(2)); 
        // Expected: -1 (removed)

        cache.put(5, 50); 
        // Evicts LRU → key 3

        cache.printCache(); 
        // Expected: [5=50] [4=40] [1=10]
    }
}