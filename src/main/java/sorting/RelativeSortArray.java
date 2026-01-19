package sorting;

import java.util.*;

public class RelativeSortArray {

    // O(a1 * a2 + d * log(d)) time | O(a1 + a2) space
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[arr2.length];

        List<Integer> remaining = new ArrayList<>();

        for (int num1 : arr1) {
            boolean is_found = false;

            for (int i = 0; i < arr2.length; i++) {
                int num2 = arr2[i];
                if (num1 == num2) {
                    is_found = true;
                    cnt[i]++;
                }
            }

            if (!is_found) {
                remaining.add(num1);
            }
        }

        Collections.sort(remaining);

        int[] res = new int[arr1.length];
        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res[idx++] = arr2[i];
            }
        }
        for (int num : remaining) {
            res[idx++] = num;
        }
        return res;
    }

    // O(m + n * log(n)) time | O(n + m) space - where n = len(arr1), m = len(arr2)
    public static int[] relativeSortArrayHashMap(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int num2 : arr2) {
            map.put(num2, 0);
        }

        for (int num1 : arr1) {
            if (map.containsKey(num1)) {
                map.put(num1, map.get(num1) + 1);
            } else {
                remaining.add(num1);
            }
        }

        Collections.sort(remaining);

        for (int num2 : arr2) {
            for (int i = 0; i < map.get(num2); i++) {
                result.add(num2);
            }
        }
        result.addAll(remaining);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // O(n+m+k) time | O(k) - where n = len(arr1), m = len(arr2), k - max(arr1)
    public static int[] relativeSortArrayCountingSort(int[] arr1, int[] arr2) {
        int maxVal = Integer.MIN_VALUE;
        for (int num1 : arr1) {
            maxVal = Math.max(maxVal, num1);
        }

        int[] cnt = new int[maxVal + 1];

        for (int num1 : arr1) {
            cnt[num1]++;
        }

        int[] res = new int[arr1.length];
        int idx = 0;

        for (int num2 : arr2) {
            while (cnt[num2] > 0) {
                res[idx++] = num2;
                cnt[num2]--;
            }
        }

        for (int i = 0; i < maxVal + 1; i++) {
            while (cnt[i] > 0) {
                res[idx++] = i;
                cnt[i]--;
            }
        }

        return res;
    }

    static void main() {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};

//        int[] exp = new int[]{2,2,2,1,4,3,3,9,6,7,19};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArrayHashMap(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArrayCountingSort(arr1, arr2)));

        arr1 = new int[]{28, 6, 22, 8, 44, 17};
        arr2 = new int[]{22, 28, 8, 6};

//        int[] exp = new int[] {22, 28, 8, 6, 17, 44};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArrayHashMap(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArrayCountingSort(arr1, arr2)));
    }
}
