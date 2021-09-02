package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache5 {

    private final int capacity;

    private final Node head = new Node();
    private final Node tail = new Node();

    private final Map<Integer, Node> cache;

    public LRUCache5(int capacity) {
        if (capacity <= 0) throw new IllegalStateException("capacity has to be positive");
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
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
            remove(node);
            add(node);
            node.value = value;
        } else {
            if (capacity == cache.size()) {
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

    public void add(Node node) {
        Node headNext = head.next;

        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

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

    }
}
