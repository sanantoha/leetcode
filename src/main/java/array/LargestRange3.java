package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange3 {

    // O(n * log(n)) time | O(1) space
    public static int[] largestRange(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Arrays.sort(arr);

        int longestRange = 0;
        int currRange = 0;
        int startRange = arr[0];
        int endRange = arr[0];
        int currStartRange = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int curr = arr[i];
            if (prev + 1 == curr) {
                currRange++;
            } else {
                currStartRange = curr;
                currRange = 1;
            }

            if (longestRange < currRange) {
                longestRange = currRange;
                startRange = currStartRange;
                endRange = curr;
            }
        }

        return new int[] {startRange, endRange};
    }

    // O(n) time | O(n) space
    public static int[] largestRange1(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Map<Integer, Boolean> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, true);
        }

        int[] bestRange = new int[0];
        int longestRange = 0;
        for (int v : arr) {
            if (!map.get(v)) continue;

            int currRange = 1;
            int l = v - 1;
            while (map.containsKey(l)) {
                map.put(l, false);
                currRange++;
                l--;
            }

            int r = v + 1;
            while (map.containsKey(r)) {
                map.put(r, false);
                currRange++;
                r++;
            }

            if (longestRange < currRange) {
                longestRange = currRange;
                bestRange = new int[] {l + 1, r - 1};
            }
        }

        return bestRange;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]

        System.out.println(Arrays.toString(largestRange1(arr))); // [0, 7]
    }
}
