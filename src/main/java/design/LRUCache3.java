package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    private final int capacity;

    private final Map<Integer, Node> cache;

    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache3(int capacity) {
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
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (cache.size() == capacity) {
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

        headNext.prev = node;
        node.next = headNext;

        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }
}
