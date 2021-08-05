package tree;

public class ConvertedSortedArrayToBST1 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        int cnt = hi - lo;
        if (cnt == 0) return new TreeNode(nums[lo]);
        else if (cnt == 1) return new TreeNode(nums[lo], null, new TreeNode(nums[hi]));
//        else if (cnt == 2) return new TreeNode(nums[lo + 1], new TreeNode(lo), new TreeNode(hi));

        int n = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[n]);
        root.left = sortedArrayToBST(nums, lo, n - 1);
        root.right = sortedArrayToBST(nums, n + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};

        System.out.println(sortedArrayToBST(arr));
    }
}

//                    5
//        2                       8
//    1       3           6           9
//                4           7           10


//TreeNode{val=5, left=TreeNode{val=2, left=TreeNode{val=1, left=null, right=null}, right=TreeNode{val=3, left=null, right=TreeNode{val=4, left=null, right=null}}}, right=TreeNode{val=8, left=TreeNode{val=6, left=null, right=TreeNode{val=7, left=null, right=null}}, right=TreeNode{val=9, left=null, right=TreeNode{val=10, left=null, right=null}}}}