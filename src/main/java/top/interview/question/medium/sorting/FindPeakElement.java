package top.interview.question.medium.sorting;

class Solution3 {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

public class FindPeakElement {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.findPeakElement(new int[] {1,2,3,1}));

        System.out.println(s.findPeakElement(new int[] {1,2,1,3,5,6,4}));


        System.out.println(s.findPeakElement(new int[] {1,2,3,4,5,6,7,6}));
        System.out.println(s.findPeakElement(new int[] {1,2}));
        System.out.println(s.findPeakElement(new int[] {1,2, 3}));
    }
}
