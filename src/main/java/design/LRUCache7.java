package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache7 {

    private int capacity;

    private Node head = new Node();
    private Node tail = new Node();

    private Map<Integer, Node> cache;

    public LRUCache7(int capacity) {
        if (capacity < 0) throw new IllegalStateException("capacity has to be greater than 0");
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
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

        node.prev = head;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }


    public static void main(String[] args) {
        LRUCache7 lRUCache = new LRUCache7(2);

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
