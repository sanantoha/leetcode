package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap6 {

    private final List<Integer> heap;

    public MinHeap6(List<Integer> array) {
        heap = buildHeap(array);
    }

    // O(n) time | O(n) space
    private List<Integer> buildHeap(List<Integer> array) {
        List<Integer> res = new ArrayList<>(array);
        for (int i = res.size() / 2; i >= 0; i--) {
            siftDown(i, res.size() - 1, res);
        }
        return res;
    }

    // O(log(n)) time
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int idx = currentIdx;

        while (true) {
            int l = left(idx);
            int r = right(idx);

            int minIdx = idx;
            if (l <= endIdx && heap.get(l) < heap.get(minIdx)) {
                minIdx = l;
            }
            if (r <= endIdx && heap.get(r) < heap.get(minIdx)) {
                minIdx = r;
            }
            if (minIdx != idx) {
                Collections.swap(heap, minIdx, idx);
                idx = minIdx;
            } else break;
        }
    }

    // O(log(n)) time
    public void siftUp(int currentIdx, List<Integer> heap) {
        int idx = currentIdx;
        int p = parent(idx);
        while (p >= 0 && heap.get(p) > heap.get(idx)) {
            Collections.swap(heap, p, idx);
            idx = p;
            p = parent(idx);
        }
    }

    // O(1)
    public int peek() {
        if (heap.isEmpty())
            return -1;
        else
            return heap.get(0);
    }

    // O(log(n)) time
    public int remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        int val = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return val;
    }

    // O(log(n)) time
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
        MinHeap6 heap = new MinHeap6(res);
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
