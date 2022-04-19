package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache10 {

    private final int capacity;
    private final Node head = new Node();
    private final Node tail = new Node();
    private final Map<Integer, Node> cache;

    public LRUCache10(int capacity) {
        if (capacity <= 0) throw new IllegalStateException("capacity should be > 0");
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head.next = tail;
        this.tail.prev = head;
    }

    // O(1) time
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        return node.value;
    }

    // O(1) time
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            add(newNode);
            cache.put(key, newNode);
        } else {
            node.value = value;
            remove(node);
            add(node);
        }
    }

    // O(1) time
    private void add(Node node) {
        Node nextHead = head.next;

        nextHead.prev = node;
        node.next = nextHead;
        head.next = node;
        node.prev = head;
    }

    // O(1) time
    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    public static void main(String[] args) {
        LRUCache10 lRUCache = new LRUCache10(2);

        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
