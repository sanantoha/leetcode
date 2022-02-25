package design;

import java.util.ArrayList;
import java.util.List;

public class MinHeap6 {
    private final List<Integer> heap;

    public MinHeap6(List<Integer> array) {
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
