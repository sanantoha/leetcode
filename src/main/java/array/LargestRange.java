package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        if (array == null || array.length == 0) return new int[] {};

        Arrays.sort(array);

        int currMax = 0;
        int max = 0;
        int startVal = array[0];
        int endVal = -1;
        int currStartVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] + 1 == array[i]) {
                currMax++;
            } else {
                currMax = 1;
                currStartVal = array[i];
            }

            if (max < currMax) {
                max = currMax;
                startVal = currStartVal;
                endVal = array[i];
            }
        }
        return new int[] {startVal, endVal};
    }

    public static int[] largestRange1(int[] array) {
        if (array == null || array.length == 0) return new int[] {};

        Map<Integer, Boolean> map = new HashMap<>();
        for (int v : array) {
            map.put(v, true);
        }
        int[] bestRange = null;
        int longestRange = 0;
        for (int num : array) {
            if (!map.get(num)) continue;

            int currRange = 1;
            int l = num - 1;
            while (map.containsKey(l)) {
                currRange++;
                map.put(l, false);
                l--;
            }
            int r = num + 1;
            while (map.containsKey(r)) {
                currRange++;
                map.put(r, false);
                r++;
            }

            if (currRange > longestRange) {
                longestRange = currRange;
                bestRange = new int[] {l + 1, r - 1};
            }
        }

        return bestRange;
    }

    public static void main(String[] args) {
        // 1st solution sort array
        // 2nd use hashmap
        // check https://www.algoexpert.io/questions/Largest%20Range

        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};

        System.out.println(Arrays.toString(largestRange(arr))); // [0, 7]

        System.out.println(Arrays.toString(largestRange1(arr))); // [0, 7]
    }
}
