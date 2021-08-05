package top.interview.question.medium.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import top.interview.question.easy.trees.TreeNode;


public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "null";

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        List<String> lst = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr == null) {
                lst.add("#");
            } else {
                lst.add(String.valueOf(curr.val));
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }

        return String.join(",", lst);
    }

    int index;

    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] arr = data.split("[,]");

        index = 0;
        return helper(arr);
    }

    private TreeNode helper(String[] arr) {
        if ("#".equals(arr[index])) return null;

        TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
        index++;
        root.left = helper(arr);
        index++;
        root.right = helper(arr);
        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));

        System.out.println(codec.serialize(root));

        TreeNode root1 = new TreeNode(1);

        System.out.println(codec.serialize(root1));

//        System.out.println(codec.serialize0(null));

        TreeNode desRoot = codec.deserialize("1,2,#,#,3,4,#,#,5,#,#");
        System.out.println(root);
        System.out.println(desRoot);
//
//
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
//
        System.out.println(codec.serialize(root3));
//
        System.out.println(codec.deserialize("1,#,2,#,#"));
//
        TreeNode root4 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(6),
                                new TreeNode(7)),
                        new TreeNode(5)));

        System.out.println(codec.serialize(root4));

        TreeNode root4Src = codec.deserialize("1,2,#,#,3,4,6,#,#,7,#,#,5,#,#");
        System.out.println(root4Src);
        System.out.println(codec.serialize(root4Src));

        TreeNode root5 = new TreeNode(1, new TreeNode(2), new TreeNode(2));

        System.out.println(codec.serialize(root5));
//        System.out.println(codec.deserialize("[1, 2, 2]|[2, 1, 2]"));


//        TreeNode root5 = new TreeNode(4,
//                new TreeNode(-7),
//                new TreeNode(-3,
//                        new TreeNode(-9,
//                                new TreeNode(9,
//                                        new TreeNode(6,
//                                                new TreeNode(0,
//                                                        null,
//                                                        new TreeNode(-1)),
//                                                new TreeNode(6,
//                                                        new TreeNode(-4),
//                                                        null)),
//                                        null),
//                                new TreeNode(-7,
//                                        new TreeNode(-6,
//                                                new TreeNode(5),
//                                                null),
//                                        new TreeNode(-6,
//                                                new TreeNode(9,
//                                                        new TreeNode(-2),
//                                                        null),
//                                                null))),
//                        new TreeNode(-3,
//                                new TreeNode(-4),
//                                null))
//        );
//
//        System.out.println(codec.serialize0(root5));
//
//        TreeNode desRoot5 = codec.deserialize0("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2,null,null,null,null,null,null,null]");
//        System.out.println(desRoot5);


//        String root5Src = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
//        TreeNode root5 = codec.deserialize0(root5Src);
//
//        System.out.println(root5Src);
//        System.out.println(codec.serialize0(root5));
    }
}
