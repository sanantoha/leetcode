package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache9 {

    private int capacity;

    private final Map<Integer, Node> cache;

    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache9(int capacity) {
        if (capacity < 1) throw new IllegalStateException("capacity has to be > 0");
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    // O(1) time | O(1) space
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        remove(node);
        add(node);
        return node.value;
    }

    // O(1) time | O(1) space
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            add(newNode);
        }
    }

    private void add(Node node) {
       Node headNext = head.next;

       node.next = headNext;
       headNext.prev = node;
       head.next = node;
       node.prev = head;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }


    public static void main(String[] args) {
        LRUCache9 lRUCache = new LRUCache9(2);

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
