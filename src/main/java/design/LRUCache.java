package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

    private final Node head = new Node();
    private final Node tail = new Node();

    private final int capacity;

    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        if (capacity < 1) throw new IllegalStateException("capacity must be positive value");
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            map.put(key, newNode);
            add(newNode);
        }
    }

    private void add(Node node) {
        Node headNext = head.next;

        node.next = headNext;
        node.prev = head;

        head.next = node;
        headNext.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

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

