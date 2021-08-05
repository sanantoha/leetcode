package tree;

public class ConvertedSortedArrayToBST2 {

    public static TreeNode sortedArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        return sortedArrayToBST(arr, 0, arr.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] arr, int lo, int hi) {
        if (lo == hi) return new TreeNode(arr[lo]);
        else if (hi - lo == 1) return new TreeNode(arr[lo], null, new TreeNode(arr[hi]));

        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBST(arr, lo, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9, 10};

        // TreeNode{val=5, left=TreeNode{val=2, left=TreeNode{val=1, left=null, right=null}, right=TreeNode{val=3, left=null, right=TreeNode{val=4, left=null, right=null}}}, right=TreeNode{val=8, left=TreeNode{val=6, left=null, right=TreeNode{val=7, left=null, right=null}}, right=TreeNode{val=9, left=null, right=TreeNode{val=10, left=null, right=null}}}}
        System.out.println(sortedArrayToBST(arr));
    }
}
