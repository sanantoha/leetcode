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
        return null;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
    }

    public int peek() {
        return -1;
    }

    public int remove() {
        return -1;
    }

    public void insert(int value) {
    }

    public boolean isEmpty() {
        return heap.isEmpty();
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

        System.out.println(heap.heap); // [0, 1, 2, 3, 4, 5]

        System.out.println(heap.peek()); // 0
        System.out.println(heap.remove()); // 0
        System.out.println(heap.heap); // [1, 3, 2, 5, 4]

        System.out.println(heap.remove()); // 1
        System.out.println(heap.remove()); // 2

        heap.insert(4);

        System.out.println(heap.heap); // [3, 4, 4, 5]
    }
}
