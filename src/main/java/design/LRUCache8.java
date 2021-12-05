package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache8 {

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache8(int capacity) {
        if (capacity <= 0) throw new IllegalStateException("Capacity has to be more than zero");
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head.next = tail;
        this.tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            add(node);
            node.val = value;
        } else {
            if (capacity == cache.size()) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            cache.put(key, newNode);
            add(newNode);
        }
    }

    private void add(Node node) {
        Node headNext = head.next;

        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }


    public static void main(String[] args) {
        LRUCache8 lRUCache = new LRUCache8(2);

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
