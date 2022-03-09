package tree;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK3 {

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
        if (tree == null || k <= 0) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        populateParents(parents, tree, null);

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
               while (!queue.isEmpty()) res.add(queue.remove().tree.value);
               return res;
            }
            List<BinaryTree> connectedNodes = Arrays.asList(curr.left, curr.right, parents.get(curr.value));
            for (BinaryTree node : connectedNodes) {
                if (node == null) continue;
                if (seen.contains(node.value)) continue;
                seen.add(node.value);
                queue.add(new TreeInfo(node, distance + 1));
            }
        }
        return Collections.emptyList();
    }

    static class TreeInfo {
        BinaryTree tree;
        int distance;

        public TreeInfo(BinaryTree tree, int distance) {
            this.tree = tree;
            this.distance = distance;
        }
    }

    private static void populateParents(Map<Integer, BinaryTree> parents, BinaryTree tree, BinaryTree parent) {
        if (tree == null) return;

        parents.put(tree.value, parent);
        populateParents(parents, tree.left, tree);
        populateParents(parents, tree.right, tree);
    }

    private static BinaryTree getNodeByValue(Map<Integer, BinaryTree> parents, BinaryTree tree, int target) {
        if (tree.value == target) return tree;

        BinaryTree parent = parents.get(target);
        if (parent != null && parent.left.value == target) return parent.left;
        return parent.right;
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k <= 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        populateParents(parents, tree, null);

        BinaryTree targetNode = getNodeByValue(parents, tree, target);

        List<Integer> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        findNodes(targetNode, 0, k, parents, seen, res);

        return res;
    }

    private static void findNodes(BinaryTree node, int distance, int k, Map<Integer, BinaryTree> parents, Set<Integer> seen, List<Integer> res) {
        if (node == null || seen.contains(node.value)) return;

        seen.add(node.value);

        if (distance == k) {
            res.add(node.value);
            return;
        }

        findNodes(node.left, distance + 1, k, parents, seen, res);
        findNodes(node.right, distance + 1, k, parents, seen, res);
        findNodes(parents.get(node.value), distance + 1, k, parents, seen, res);
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
