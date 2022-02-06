package tree;

public class ConvertedSortedArrayToBST3 {

    // O(n) time | O(n) space
    public static TreeNode sortedArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        return arrayToBST(arr, 0, arr.length - 1);
    }

    private static TreeNode arrayToBST(int[] arr, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) >>> 1;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBST(arr, l, mid - 1);
        root.right = arrayToBST(arr, mid + 1, r);
        return root;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9, 10};

        // TreeNode{val=5, left=TreeNode{val=2, left=TreeNode{val=1, left=null, right=null}, right=TreeNode{val=3, left=null, right=TreeNode{val=4, left=null, right=null}}}, right=TreeNode{val=8, left=TreeNode{val=6, left=null, right=TreeNode{val=7, left=null, right=null}}, right=TreeNode{val=9, left=null, right=TreeNode{val=10, left=null, right=null}}}}
        TreeNode tree = sortedArrayToBST(arr);
        System.out.println(tree);
    }
}
