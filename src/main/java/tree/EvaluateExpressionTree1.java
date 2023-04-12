package tree;

public class EvaluateExpressionTree1 {

    static class BinaryTree {
        public int value;
        public EvaluateExpressionTree.BinaryTree left = null;
        public EvaluateExpressionTree.BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int evaluateExpressionTree(EvaluateExpressionTree.BinaryTree tree) {
        // Write your code here.
        return -1;
    }

    public static void main(String[] args) {
        var tree = new EvaluateExpressionTree.BinaryTree(-1);
        tree.left = new EvaluateExpressionTree.BinaryTree(-2);
        tree.left.left = new EvaluateExpressionTree.BinaryTree(-4);
        tree.left.right = new EvaluateExpressionTree.BinaryTree(2);
        tree.left.left.left = new EvaluateExpressionTree.BinaryTree(3);
        tree.left.left.right = new EvaluateExpressionTree.BinaryTree(2);

        tree.right = new EvaluateExpressionTree.BinaryTree(-3);
        tree.right.left = new EvaluateExpressionTree.BinaryTree(8);
        tree.right.right = new EvaluateExpressionTree.BinaryTree(3);
        int expected = 6;
        int actual = evaluateExpressionTree(tree);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
