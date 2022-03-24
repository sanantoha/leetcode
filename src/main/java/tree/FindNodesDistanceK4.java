package tree;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK4 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(tree, null, parents);

        BinaryTree targetNode = getNodeByValue(parents, tree, target);

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(targetNode, 0));
        Set<Integer> seen = new HashSet<>();
        seen.add(target);

        while (!queue.isEmpty()) {
            TreeInfo ti = queue.remove();
            int distance = ti.distance;
            BinaryTree curr = ti.tree;

            if (distance == k) {
                res.add(curr.value);
                while (!queue.isEmpty()) {
                    res.add(queue.remove().tree.value);
                }
                break;
            }

            List<BinaryTree> nodes = Arrays.asList(curr.left, curr.right, parents.get(curr.value));
            for (BinaryTree node : nodes) {
                if (node == null || seen.contains(node.value)) {
                    continue;
                }
                seen.add(node.value);
                queue.add(new TreeInfo(node, distance + 1));
            }
        }

        return res;
    }

    static class TreeInfo {
        BinaryTree tree;
        int distance;

        public TreeInfo(BinaryTree tree, int distance) {
            this.tree = tree;
            this.distance = distance;
        }
    }

    private static void enrichParents(BinaryTree tree, BinaryTree parent, Map<Integer, BinaryTree> parents) {
        if (tree == null) return;

        parents.put(tree.value, parent);
        enrichParents(tree.left, tree, parents);
        enrichParents(tree.right, tree, parents);
    }

    private static BinaryTree getNodeByValue(Map<Integer, BinaryTree> parents, BinaryTree tree, int target) {
        if (tree.value == target) return tree;

        BinaryTree parent = parents.get(target);
        if (parent != null && parent.left.value == target) return parent.left;
        else return parent.right;
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(tree, null, parents);

        BinaryTree targetNode = getNodeByValue(parents, tree, target);

        Set<Integer> seen = new HashSet<>();

        findNodes(targetNode, 0, k, seen, parents, res);

        return res;
    }

    private static void findNodes(BinaryTree targetNode, int distance, int k, Set<Integer> seen, Map<Integer, BinaryTree> parents, List<Integer> res) {
        if (targetNode == null || seen.contains(targetNode.value)) return;

        seen.add(targetNode.value);

        if (distance == k) {
            res.add(targetNode.value);
        } else {
            findNodes(targetNode.left, distance + 1, k, seen, parents, res);
            findNodes(targetNode.right, distance + 1, k, seen, parents, res);
            findNodes(parents.get(targetNode.value), distance + 1, k, seen, parents, res);
        }
    }


    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);
        int target = 3;
        int k = 2;
        var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
        var actual = findNodesDistanceK(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        System.out.println(expected.equals(actual));

        actual = findNodesDistanceKRec(root, target, k);
        System.out.println(actual);
        Collections.sort(actual);
        System.out.println(expected.equals(actual));
    }
}
