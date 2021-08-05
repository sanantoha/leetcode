package tree;

public class ConvertedSortedArrayToBST {

    private static TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (hi == lo) return new TreeNode(nums[lo]);
        else if (hi - lo == 1) return new TreeNode(nums[hi], new TreeNode(nums[lo]), null);
        else if (hi - lo == 2) return new TreeNode(nums[lo + 1], new TreeNode(nums[lo]), new TreeNode(nums[hi]));

        int n = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[n]);
        root.left = sortedArrayToBST(nums, lo, n - 1);
        root.right = sortedArrayToBST(nums, n + 1, hi);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0,
//                new TreeNode(-3,
//                        new TreeNode(-10),
//                        null),
//                new TreeNode(9,
//                        new TreeNode(5),
//                        null)
//        );

        System.out.println(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
    }
}
