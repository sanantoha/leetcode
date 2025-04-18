package tree;

public class EvaluateExpressionTree1 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int evaluateExpressionTree(BinaryTree tree) {
        return -1;
    }

    public static void main(String[] args) {
        var tree = new BinaryTree(-1);
        tree.left = new BinaryTree(-2);
        tree.left.left = new BinaryTree(-4);
        tree.left.right = new BinaryTree(2);
        tree.left.left.left = new BinaryTree(3);
        tree.left.left.right = new BinaryTree(2);

        tree.right = new BinaryTree(-3);
        tree.right.left = new BinaryTree(8);
        tree.right.right = new BinaryTree(3);
        int expected = 6;
        int actual = evaluateExpressionTree(tree);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
