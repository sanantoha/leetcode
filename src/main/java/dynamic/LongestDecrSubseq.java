package dynamic;

import java.util.*;

public class LongestDecrSubseq {

    // O(n ^ 2) time | O(n) space
    public static int lds(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                }
            }
            if (max < lengths[i]) {
                max = lengths[i];
            }
        }

        return max;
    }

    // O(n ^ 2) time | O(n) space
    public static List<Integer> ldsList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;

        int[] lengths = new int[arr.length];
        Arrays.fill(lengths, 1);
        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                    prev[i] = j;
                }
            }
            if (max < lengths[i]) {
                max = lengths[i];
                maxIdx = i;
            }
        }

        return buildList(arr, prev, maxIdx);
    }

    private static List<Integer> buildList(int[] arr, int[] prev, int maxIdx) {
        Deque<Integer> stack = new LinkedList<>();
        while (maxIdx != -1) {
            stack.push(arr[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        return new ArrayList<>(stack);
    }

    // O(n * log(n)) time | O(n) space
    public static int lds1(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        List<Integer> res = new ArrayList<>();
        res.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int prev = res.get(res.size() - 1);
            if (prev > arr[i]) {
                res.add(arr[i]);
            } else {
                int j = Collections.binarySearch(res, arr[i], Comparator.reverseOrder());//binarySearch(res, arr[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, arr[i]);
            }
        }

        return res.size();
    }

    // O(n * log(n)) time | O(n) space
    public static List<Integer> ldsList1(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        int[] indices = new int[arr.length + 1];
        Arrays.fill(indices, -1);

        int[] prev = new int[arr.length];
        Arrays.fill(prev, -1);

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int newLength = binarySearch(arr, indices, 1, length, arr[i]);
            prev[i] = indices[newLength - 1];
            indices[newLength] = i;
            length = Math.max(length, newLength);
        }

        return buildList(arr, prev, indices[length]);
    }

    private static int binarySearch(int[] arr, int[] indices, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target > arr[indices[mid]]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int binarySearch(List<Integer> lst, int target) {
        int l = 0;
        int r = lst.size() - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (target <= lst.get(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return lst.get(l) == target ? l : -(l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,6,5,4,3,10,14,12};

        System.out.println(lds(arr));
        System.out.println(lds1(arr));
        System.out.println(ldsList(arr));
        System.out.println(ldsList1(arr));

        int[] arr1 = {100, 10, 9, 8, 7, 6, 5, 90, 80, 70, 60, 50, 40, 30, 20};
        System.out.println(lds(arr1));
        System.out.println(lds1(arr1));
        System.out.println(ldsList(arr1));
        System.out.println(ldsList1(arr1));
    }
}
