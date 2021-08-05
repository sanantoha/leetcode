package top.interview.question.apple;


public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lenFst = nums1.length;
        int lenSnd = nums2.length;

        int lo = 0;
        int hi = lenFst;

        while (lo <= hi) {
            int partitionFst = (lo + hi) >>> 1;
            int partitionSnd = (lenFst + lenSnd + 1) / 2 - partitionFst;

            int maxLeftFst = (partitionFst == 0) ? Integer.MIN_VALUE : nums1[partitionFst - 1];
            int minRightFst = (partitionFst == lenFst) ? Integer.MAX_VALUE : nums1[partitionFst];

            int maxLeftSnd = (partitionSnd == 0) ? Integer.MIN_VALUE : nums2[partitionSnd - 1];
            int minRightSnd = (partitionSnd == lenSnd) ? Integer.MAX_VALUE : nums2[partitionSnd];

            if (maxLeftFst <= minRightSnd && minRightFst >= maxLeftSnd) {
                if ((lenFst + lenSnd) % 2 == 0) {
                    return (Math.max(maxLeftFst, maxLeftSnd) + Math.min(minRightFst, minRightSnd)) / 2.0;
                } else {
                    return Math.max(maxLeftFst, maxLeftSnd);
                }
            } else if (maxLeftFst > minRightSnd) {
                hi = partitionFst - 1;
            } else {
                lo = partitionFst + 1;
            }
        }

        throw new UnsupportedOperationException();
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 9, 15}; // 1, 3, 7, 8, 9, 11, 15, 19, 21, 23, 25
        int[] nums2 = {7, 11, 19, 21, 23, 25};

        System.out.println(nums1.length + nums2.length);

        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] arr1 = {0, 3, 5, 7, 9};   // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 => 5
        int[] arr2 = {1, 2, 4, 6, 8, 10, 11};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
