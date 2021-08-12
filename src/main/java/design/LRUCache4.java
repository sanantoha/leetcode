package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache4 {

    private int capacity;

    private Node head = new Node();
    private Node tail = new Node();

    private Map<Integer, Node> cache;

    public LRUCache4(int capacity) {
        if (capacity < 0) throw new IllegalStateException("Capacity has to be greater than zero");
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

        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
        // head -> headNext
        // head <- headNext
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
        Node next;
        Node prev;
    }
}
