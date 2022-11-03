package array;

public class MedianOfTwoSortedArrays {

    // O(l1 + l2) time | O(l1 + l2) space
    public static double median(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calc(arr2);
        if (arr2 == null || arr2.length == 0) return calc(arr1);
        return calc(merge(arr1, arr2));
    }

    public static double calc(int[] arr) {
        if (arr == null || arr.length == 0) return Double.NaN;
        int med = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (arr[med - 1] + arr[med]) / 2.0d;
        } else {
            return arr[med];
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                res[idx++] = arr1[i++];
            } else {
                res[idx++] = arr2[j++];
            }
        }

        while (i < arr1.length) res[idx++] = arr1[i++];
        while (j < arr2.length) res[idx++] = arr2[j++];

        return res;
    }

    // O(log(min(l1, l2)) time | O(1) space
    public static double median1(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calc(arr2);
        if (arr2 == null || arr2.length == 0) return calc(arr1);

        if (arr1.length > arr2.length) return median1(arr2, arr1);

        int n1 = arr1.length;
        int n2 = arr2.length;
        int l = 0;
        int r = n1;
        while (l <= r) {
            int med1 = (l + r) >>> 1;
            int med2 = (n1 + n2 + 1) / 2 - med1;

            int maxLeft1 = (med1 == 0) ? Integer.MIN_VALUE : arr1[med1 - 1];
            int minRight1 = (med1 == n1) ? Integer.MAX_VALUE : arr1[med1];
            int maxLeft2 = (med2 == 0) ? Integer.MIN_VALUE : arr2[med2 - 1];
            int minRight2 = (med2 == n2) ? Integer.MAX_VALUE : arr2[med2];

            if (maxLeft1 < minRight2 && maxLeft2 < minRight1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0d;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                r = med1 - 1;
            } else {
                l = med1 + 1;
            }
        }
        return -1;
    }

    // 0, 3, 5,      7, 9
    // 1, 2, 4,      6, 8, 10, 11
    public static void main(String[] args) {
        int[] arr1 = {0, 3, 5, 7, 9};   // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 => 5
        int[] arr2 = {1, 2, 4, 6, 8, 10};

        System.out.println(median(arr1, arr2));
        System.out.println(median1(arr1, arr2));
        //    arr1  arr2
        // 1) arr1 == null && arr2 == null
        // 2) arr1 == null || arr2 == null
    }
}
