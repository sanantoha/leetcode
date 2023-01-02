package tree;

/**
 * https://www.algoexpert.io/questions/merge-binary-trees
 */
public class MergeBinaryTrees1 {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "val=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        return null;
    }

    public static BinaryTree mergeBinaryTreesIter(BinaryTree tree1, BinaryTree tree2) {
        return null;
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(3);
        tree1.left.left = new BinaryTree(7);
        tree1.left.right = new BinaryTree(4);
        tree1.right = new BinaryTree(2);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(5);
        tree2.left.left = new BinaryTree(2);
        tree2.right = new BinaryTree(9);
        tree2.right.left = new BinaryTree(7);
        tree2.right.right = new BinaryTree(6);

        BinaryTree actual = mergeBinaryTrees(tree1, tree2);
        System.out.println(actual);

        System.out.println(actual.value == 2);
        System.out.println(actual.left.value == 8);
        System.out.println(actual.left.left.value == 9);
        System.out.println(actual.left.right.value == 4);
        System.out.println(actual.right.value == 11);
        System.out.println(actual.right.left.value == 7);
        System.out.println(actual.right.right.value == 6);




        BinaryTree tree3 = new BinaryTree(1);
        tree3.left = new BinaryTree(3);
        tree3.left.left = new BinaryTree(7);
        tree3.left.right = new BinaryTree(4);
        tree3.right = new BinaryTree(2);

        BinaryTree tree4 = new BinaryTree(1);
        tree4.left = new BinaryTree(5);
        tree4.left.left = new BinaryTree(2);
        tree4.right = new BinaryTree(9);
        tree4.right.left = new BinaryTree(7);
        tree4.right.right = new BinaryTree(6);

        actual = mergeBinaryTreesIter(tree3, tree4);
        System.out.println(actual);

        System.out.println(actual.value == 2);
        System.out.println(actual.left.value == 8);
        System.out.println(actual.left.left.value == 9);
        System.out.println(actual.left.right.value == 4);
        System.out.println(actual.right.value == 11);
        System.out.println(actual.right.left.value == 7);
        System.out.println(actual.right.right.value == 6);
    }
}
