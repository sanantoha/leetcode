package array;

public class MedianOfTwoSortedArrays4 {

    public static double median(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calcMedian(arr2);
        if (arr2 == null || arr2.length == 0) return calcMedian(arr1);

        int[] arr = merge(arr1, arr2);
        return calcMedian(arr);
    }

    private static double calcMedian(int[] arr) {
        int len = arr.length;
        if (len % 2 == 0) {
            return (arr[len / 2] + arr[len / 2 - 1]) / 2.0d;
        }
        return arr[len / 2];
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) res[k++] = arr1[i++];
        while (j < arr2.length) res[k++] = arr2[j++];
        return res;
    }

    public static double median1(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calcMedian(arr2);
        if (arr2 == null || arr2.length == 0) return calcMedian(arr1);

        if (arr1.length > arr2.length) return median1(arr2, arr1);

        int len1 = arr1.length;
        int len2 = arr2.length;

        int l = 0;
        int r = len1 - 1;

        while (l <= r) {
            int mid1 = (l + r) / 2;
            int mid2 = (len1 + len2 + 1) / 2  - mid1;

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
        int[] arr1 = {1,3,5,7,9, 11}; // 1 2 3 4 5 6 7 8 9 10 11 12
        int[] arr2 = {2,4,6,8,10, 12, 13};
        System.out.println(median(arr1, arr2));
        System.out.println(median1(arr1, arr2));
    }
}
