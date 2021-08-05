package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    private int capacity;

    private Map<Integer, Node> cache;

    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache2(int capacity) {
        if (capacity <= 0) throw new IllegalStateException("capacity has to be positive");
        this.capacity = capacity;
        this.cache = new HashMap<>();
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

    public void add(Node node) {
        Node headNext = head.next;
        headNext.prev = node;
        head.next = node;
        node.next = headNext;
        node.prev = head;
    }

    public void remove(Node node) {
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
