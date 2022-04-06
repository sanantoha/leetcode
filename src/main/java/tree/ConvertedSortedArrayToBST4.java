package tree;

public class ConvertedSortedArrayToBST4 {

    // O(n) time | O(n) space
    public static TreeNode sortedArrayToBST(int[] arr) {
        return arrayToBST(arr, 0, arr.length - 1);
    }

    private static TreeNode arrayToBST(int[] arr, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(arr[l]);
        int idx = (l + r) >>> 1;
        TreeNode root = new TreeNode(arr[idx]);
        root.left = arrayToBST(arr, l, idx - 1);
        root.right = arrayToBST(arr, idx + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9, 10};

        // TreeNode{val=5, left=TreeNode{val=2, left=TreeNode{val=1, left=null, right=null}, right=TreeNode{val=3, left=null, right=TreeNode{val=4, left=null, right=null}}}, right=TreeNode{val=8, left=TreeNode{val=6, left=null, right=TreeNode{val=7, left=null, right=null}}, right=TreeNode{val=9, left=null, right=TreeNode{val=10, left=null, right=null}}}}
        TreeNode tree = sortedArrayToBST(arr);
        System.out.println(tree);
    }
}
