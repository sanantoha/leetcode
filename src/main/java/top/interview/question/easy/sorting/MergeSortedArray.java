package top.interview.question.easy.sorting;

import java.util.Arrays;

class Solution0 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        for (int i = m - 1; i >= 0; i--) {
            nums1[k--] = nums1[i];
        }

        int i = k + 1;
        int j = 0;
        int z = 0;
        while (i < nums1.length && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[z++] = nums1[i++];
            } else {
                nums1[z++] = nums2[j++];
            }
        }

        while (i < nums1.length) nums1[z++] = nums1[i++];
        while (j < n) nums1[z++] = nums2[j++];
    }
}

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        int[] nums1 = {1}; //{1,2,3,4, 0,0,0};
        int[] nums2 = {}; //{2,5,6};

        s.merge(nums1, 1, nums2, 0);

        System.out.println(Arrays.toString(nums1));
    }
}
