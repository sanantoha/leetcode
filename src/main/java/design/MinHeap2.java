package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap2 {

    private final List<Integer> heap;

    public MinHeap2(List<Integer> array) {
        heap = buildHeap(array);
    }

    private List<Integer> buildHeap(List<Integer> array) {
        List<Integer> heap = new ArrayList<>(array);
        for (int i = heap.size() / 2; i >= 0; i--) {
            siftDown(i, heap.size() - 1, heap);
        }
        return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int l = left(currentIdx);
        int r = right(currentIdx);

        int minIdx = currentIdx;

        if (l <= endIdx && heap.get(l) < heap.get(minIdx)) {
            minIdx = l;
        }

        if (r <= endIdx && heap.get(r) < heap.get(minIdx)) {
            minIdx = r;
        }

        if (minIdx != currentIdx) {
            Collections.swap(heap, minIdx, currentIdx);
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
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }

    public int remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        int value = heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return value;
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
        MinHeap2 heap = new MinHeap2(res);
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
