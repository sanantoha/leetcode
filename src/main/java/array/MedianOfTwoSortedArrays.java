package array;

public class MedianOfTwoSortedArrays {

    private static int[] merge(int[] arr1, int[] arr2) { // O(l1 + l2)
        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];

        return result;
    }

    public static double median(int[] arr1, int[] arr2) {
        int[] merged;
        if (arr1 == null && arr2 == null) return 0d;
        if (arr1 == null) merged = arr2;
        else if (arr2 == null) merged = arr1;
        else merged = merge(arr1, arr2);

        int ind = merged.length / 2;

        if (merged.length % 2 == 0) {
            return (merged[ind] + merged[ind - 1]) / 2.0;
        } else return merged[merged.length / 2]; // O(1)
    }

    public static double median1(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return 0d;

        if (arr1.length > arr2.length) return median1(arr2, arr1);

        int len1 = arr1.length;
        int len2 = arr2.length;

        int l = 0;
        int r = len1;

        while (l <= r) {
            int mid1 = (l + r) >>> 1;
            int mid2 = (len1 + len2 + 1) / 2 - mid1;

            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int minRight1 = (mid1 == len1) ? Integer.MAX_VALUE : arr1[mid1];

            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int minRight2 = (mid2 == len2) ? Integer.MAX_VALUE : arr2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }

        throw new UnsupportedOperationException("error");
    }

    // 0, 3, 5,      7, 9
    // 1, 2, 4,      6, 8, 10, 11
    public static void main(String[] args) {
        int[] arr1 = {0, 3, 5, 7, 9};   // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 => 5
        int[] arr2 = {1, 2, 4, 6, 8, 10, 11};

        System.out.println(median(arr1, arr2));
        System.out.println(median1(arr1, arr2));
        //    arr1  arr2
        // 1) arr1 == null && arr2 == null
        // 2) arr1 == null || arr2 == null
    }
}
