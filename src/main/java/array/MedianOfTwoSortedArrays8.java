package array;

public class MedianOfTwoSortedArrays8 {

    // O(n) time | O(n) space
    public static double median(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return getMedian(arr2);
        if (arr2 == null || arr2.length == 0) return getMedian(arr1);
        int[] arr = merge(arr1, arr2);
        return getMedian(arr);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] res = new int[arr1.length + arr2.length];

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

    private static double getMedian(int[] arr) {
        int len = arr.length;
        if (len % 2 == 0) {
            int mid = len / 2;
            return (arr[mid] + arr[mid - 1]) / 2.0;
        } else return (double) arr[len / 2];
    }

    // O(log(n)) time | O(1) space
    public static double median1(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return getMedian(arr2);
        if (arr2 == null || arr2.length == 0) return getMedian(arr1);

        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 > len2) {
            return median1(arr2, arr1);
        }

        int l = 0;
        int r = len1;
        while (l <= r) {
            int mid1 = (l + r) / 2;
            int mid2 = (len1 + len2 + 1) / 2 - mid1;

            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int minRight1 = (mid1 == len1) ? Integer.MAX_VALUE : arr1[mid1];

            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int minRight2 = (mid2 == len2) ? Integer.MAX_VALUE : arr2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0d;
                }
                return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6}; // 1 2 3 4 5 6 7 8 9 10 11 12
        int[] arr2 = {7,8,9,10,11, 12, 13};
        System.out.println(median(arr1, arr2));
        System.out.println(median1(arr1, arr2));
    }
}
