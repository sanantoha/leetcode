package top.interview.question.apple;

public class MedianOfTwoSortedArrays1 {

    public static double findMedianSortedArraysSimple(int[] arr1, int[] arr2) {
        int[] merged = merge(arr1, arr2);

        if (merged.length % 2 == 0) {
            int ind = merged.length / 2;
            return (merged[ind] + merged[ind - 1]) / 2.0;
        } else {
            return merged[merged.length / 2];
        }
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        int l1 = 0;
        int l2 = 0;
        int r1 = arr1.length;
        int r2 = arr2.length;
        int ind = 0;

        while (l1 < r1 && l2 < r2) {
            if (arr1[l1] <= arr2[l2]) {
                res[ind++] = arr1[l1++];
            } else {
                res[ind++] = arr2[l2++];
            }
        }

        while (l1 < r1) res[ind++] = arr1[l1++];
        while (l2 < r2) res[ind++] = arr2[l2++];

        return res;
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int len1 = arr1.length;
        int len2 = arr2.length;

        int l = 0;
        int r = len1 - 1;

        while (l <= r) {
            int mid1 = (l + r) >>> 1; // lo + (r - l) / 2
            int mid2 = (len1 + len2 + 1) / 2 - mid1;

            int lMax1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int rMin1 = (mid1 == len1) ? Integer.MAX_VALUE : arr1[mid1];

            int lMax2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int rMin2 = (mid2 == len2) ? Integer.MAX_VALUE : arr2[mid2];

            if (lMax1 <= rMin2 && lMax2 <= rMin1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(lMax1, lMax2) + Math.min(rMin1, rMin2)) / 2.0;
                } else {
                    return Math.max(lMax1, lMax2);
                }
            } else if (lMax1 > rMin2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }

        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 9, 15, 16}; // 1, 3, 7, 8, 9, 11, 15, 19, 21, 23, 25
        int[] nums2 =    {7, 11, 19, 21, 23, 25};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArraysSimple(nums1, nums2));


    }
}
