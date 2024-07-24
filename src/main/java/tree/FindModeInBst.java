package tree;

import java.util.*;

public class FindModeInBst {

    // O(n) time | O(1) space
    private static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();

        int counter = 0;
        int maxCount = 0;
        int prev = Integer.MIN_VALUE;

        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev == curr.val) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter == maxCount) {
                res.add(curr.val);
            } else if (counter > maxCount) {
                maxCount = Math.max(maxCount, counter);
                res = new ArrayList<>();
                res.add(curr.val);
            }

            prev = curr.val;
            curr = curr.right;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(2),
                        null
                )
        );
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(5),
                        new TreeNode(7)
                )
        );


        System.out.println(Arrays.toString(findMode(root)));  // [2]
        System.out.println(Arrays.toString(findMode(root1))); // [0]
        System.out.println(Arrays.toString(findMode(root2))); // [3, 5, 7]
    }
}
