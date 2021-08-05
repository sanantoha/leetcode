package top.interview.question.easy.trees;

class Solution4 {

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        else if (end - start == 1) {
            return new TreeNode(nums[start], null, new TreeNode(nums[end]));
        }
        else if (end - start == 2) {
            return new TreeNode(nums[start + 1], new TreeNode(nums[start]), new TreeNode(nums[end]));
        }
        else {
            int mid = start + (end - start) / 2;
            TreeNode l = sortedArrayToBST(nums, start, mid - 1);
            TreeNode r = sortedArrayToBST(nums, mid + 1, end);
            return new TreeNode(nums[mid], l, r);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        int[] nums = {-10,-3,0,5,9};

        System.out.println(s.sortedArrayToBST(nums));

        int[] nums1 = {0,1,2,3,4,5,6,7};

        System.out.println(s.sortedArrayToBST(nums1));
    }
}
