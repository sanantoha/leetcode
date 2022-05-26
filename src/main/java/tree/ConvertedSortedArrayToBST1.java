package tree;

public class ConvertedSortedArrayToBST1 {

    public static TreeNode sortedArrayToBST(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9, 10};

        // TreeNode{val=5, left=TreeNode{val=2, left=TreeNode{val=1, left=null, right=null}, right=TreeNode{val=3, left=null, right=TreeNode{val=4, left=null, right=null}}}, right=TreeNode{val=8, left=TreeNode{val=6, left=null, right=TreeNode{val=7, left=null, right=null}}, right=TreeNode{val=9, left=null, right=TreeNode{val=10, left=null, right=null}}}}
        System.out.println(sortedArrayToBST(arr));
    }
}
