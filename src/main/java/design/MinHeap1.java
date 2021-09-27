package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap1 {

    private final List<Integer> heap;

    public MinHeap1(List<Integer> array) {
        heap = buildHeap(array);
    }

    private List<Integer> buildHeap(List<Integer> array) {
        List<Integer> heap = new ArrayList<>(array);
        for (int i = array.size() / 2; i >= 0; i--) {
            siftDown(i, array.size() - 1, heap);
        }
        return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int l = left(currentIdx);
        int r = right(currentIdx);

        int minIdx = currentIdx;
        if (l <= endIdx && heap.get(minIdx) > heap.get(l)) {
            minIdx = l;
        }
        if (r <= endIdx && heap.get(minIdx) > heap.get(r)) {
            minIdx = r;
        }

        if (minIdx != currentIdx) {
            Collections.swap(heap, currentIdx, minIdx);
            siftDown(minIdx, endIdx, heap);
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int p = parent(currentIdx);

        if (p >= 0 && heap.get(p) > heap.get(currentIdx)) {
            Collections.swap(heap, p, currentIdx);
            siftUp(p, heap);
        }
    }

    public int peek() {
        if (heap.isEmpty()) return Integer.MAX_VALUE;
        return heap.get(0);
    }

    public int remove() {
        if (heap.isEmpty()) return Integer.MAX_VALUE;
        Collections.swap(heap, 0, heap.size() - 1);
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
        MinHeap1 heap = new MinHeap1(res);
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
