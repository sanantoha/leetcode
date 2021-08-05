package top.interview.question.medium.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Solution1 {
    public int[] topKFrequent0(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }

        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = queue.poll();
        }

        return top;
    }

    // ======================================================================================

    private void swap(int[] unique, int i, int j) {
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }

    private int partition(Map<Integer, Integer> count, int[] unique, int left, int right, int pivot) {
        int pivotV = count.get(unique[pivot]);

        swap(unique, pivot, right);

        int j = left;
        for (int i = left; i < right; i++) {
            if (count.get(unique[i]) < pivotV) {
                swap(unique, i, j++);
            }
        }

        swap(unique, j, right);
        return j;
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int n = count.size();
        int[] unique = new int[n];
        int i = 0;
        for (int key : count.keySet()) {
            unique[i++] = key;
        }

        quickselect(count, unique, 0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickselect(Map<Integer, Integer> count, int[] unique, int left, int right, int k) {
        if (left == right) return;

        Random rand = new Random();
        int pivotInd = left + rand.nextInt(right - left);

        int p = partition(count, unique, left, right, pivotInd);

        if (p == k) {
            return;
        } else if (p > k) {
            quickselect(count, unique, left, p - 1, k);
        } else {
            quickselect(count, unique, p + 1, right, k);
        }
    }
}

public class TopKFrequentElement {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(Arrays.toString(s.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
    }
}
