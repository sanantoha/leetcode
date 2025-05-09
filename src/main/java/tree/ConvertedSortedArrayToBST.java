package tree;

public class ConvertedSortedArrayToBST {

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
//        TreeNode root = new TreeNode(0,
//                new TreeNode(-10,
//                        null,
//                        new TreeNode(-3)),
//                new TreeNode(5,
//                        null,
//                        new TreeNode(9))
//        );

        TreeNode tree = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(tree);
    }
}
