package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap4 {

    private final List<Integer> heap;

    public MinHeap4(List<Integer> array) {
        heap = buildHeap(array);
    }

    // O(n) time | O(n) space
    private List<Integer> buildHeap(List<Integer> array) {
        List<Integer> heap = new ArrayList<>(array);
        for (int i = heap.size() / 2; i >= 0; i--) {
            siftDown(i, heap.size() - 1, heap);
        }
        return heap;
    }

    // O(log(n)) time | O(1) space
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {

        int idx = currentIdx;
        while (true) {
            int leftIdx = left(idx);
            int rightIdx = right(idx);
            int minIdx = idx;
            if (leftIdx <= endIdx && heap.get(leftIdx) < heap.get(minIdx)) {
                minIdx = leftIdx;
            }
            if (rightIdx <= endIdx && heap.get(rightIdx) < heap.get(minIdx)) {
                minIdx = rightIdx;
            }
            if (idx != minIdx) {
                Collections.swap(heap, minIdx, idx);
                idx = minIdx;
            } else break;
        }
    }

    // O(log(n)) time | O(1) space
    public void siftUp(int currentIdx, List<Integer> heap) {
        int idx = currentIdx;
        int parentIdx = parent(idx);
        while (parentIdx >= 0 && heap.get(parentIdx) > heap.get(idx)) {
            Collections.swap(heap, parentIdx, idx);
            idx = parentIdx;
            parentIdx = parent(idx);
        }
    }

    // O(1) time | O(1) space
    public int peek() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    // O(log(n)) time | O(1) space
    public int remove() {
        Collections.swap(heap,0, heap.size() - 1);
        int val = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return val;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        res.add(2);
        MinHeap4 heap = new MinHeap4(res);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

        System.out.println(heap.heap);

        System.out.println(heap.peek());
        System.out.println(heap.remove());
        System.out.println(heap.heap);

        System.out.println(heap.remove());
        System.out.println(heap.remove());

        heap.insert(4);

        System.out.println(heap.heap);
    }
}
