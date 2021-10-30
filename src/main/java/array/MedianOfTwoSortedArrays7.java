package array;

public class MedianOfTwoSortedArrays7 {

    public static double median(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calcMedian(arr2);
        if (arr2 == null || arr2.length == 0) return calcMedian(arr1);
        int[] arr = merge(arr1, arr2);
        return calcMedian(arr);
    }

    private static double calcMedian(int[] arr) {
        if (arr == null || arr.length == 0) return -1d;
        int mid = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (arr[mid] + arr[mid - 1]) / 2.0d;
        }
        return arr[mid];
    }

    private static int[] merge(int[] arr1, int[] arr2) {
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

    public static double median1(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return calcMedian(arr2);
        if (arr2 == null || arr2.length == 0) return calcMedian(arr1);

        if (arr1.length > arr2.length) {
            return median1(arr2, arr1);
        }

        int l = 0;
        int r = arr1.length;

        while (l <= r) {
            int mid1 = (l + r) / 2;
            int mid2 = (arr1.length + arr2.length + 1) / 2 - mid1;

            int leftMax1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int rightMin1 = (mid1 == arr1.length) ? Integer.MAX_VALUE : arr1[mid1];

            int leftMax2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int rightMin2 = (mid2 == arr2.length) ? Integer.MAX_VALUE : arr2[mid2];

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if ((arr1.length + arr2.length) % 2 == 0) {
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0d;
                }
                return Math.max(leftMax1, leftMax2);
            } else if (leftMax1 > rightMin2) {
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
