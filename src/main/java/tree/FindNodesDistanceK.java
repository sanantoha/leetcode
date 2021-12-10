package tree;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK {

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

        Map<Integer, BinaryTree> parents = new HashMap<>();
        populateParents(tree, null, parents);

        BinaryTree targetNode = getNodeFromValue(parents, tree, target);

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(targetNode, 0));

        Set<Integer> seen = new HashSet<>();
        seen.add(target);

        while (!queue.isEmpty()) {
            TreeInfo ti = queue.remove();
            BinaryTree node = ti.node;
            int distance = ti.distance;

            if (distance == k) {
                List<Integer> res = new ArrayList<>();
                res.add(ti.node.value);
                while (!queue.isEmpty()) res.add(queue.remove().node.value);
                return res;
            }

            List<BinaryTree> nodes = new ArrayList<>();
            nodes.add(node.left);
            nodes.add(node.right);
            nodes.add(parents.get(node.value));

            for (BinaryTree connectedNode : nodes) {
                if (connectedNode == null) continue;
                if (seen.contains(connectedNode.value)) continue;
                queue.add(new TreeInfo(connectedNode, distance + 1));
                seen.add(connectedNode.value);
            }

        }
        return new ArrayList<>();
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        populateParents(tree, null, parents);

        BinaryTree targetNode = getNodeFromValue(parents, tree, target);

        Set<Integer> seen = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        findNodesRec(targetNode, parents, seen,0, k, res);
        return res;
    }

    private static void findNodesRec(BinaryTree node, Map<Integer, BinaryTree> parents, Set<Integer> seen, int distance, int k, List<Integer> res) {
        if (node == null || seen.contains(node.value)) return;

        seen.add(node.value);

        if (distance == k) {
            res.add(node.value);
        } else {
            findNodesRec(node.left, parents, seen, distance + 1, k, res);
            findNodesRec(node.right, parents, seen, distance + 1, k, res);
            findNodesRec(parents.get(node.value), parents, seen, distance + 1, k , res);
        }
    }

    private static BinaryTree getNodeFromValue(Map<Integer, BinaryTree> parents, BinaryTree tree, int target) {
        if (tree.value == target) return tree;

        BinaryTree parent = parents.get(target);
        if (parent != null && parent.left.value == target) return parent.left;
        else return parent.right;
    }

    private static void populateParents(BinaryTree tree, BinaryTree parent, Map<Integer, BinaryTree> parents) {
        if (tree != null) {
            parents.put(tree.value, parent);
            populateParents(tree.left, tree, parents);
            populateParents(tree.right, tree, parents);
        }
    }

    static class TreeInfo {
        BinaryTree node;
        int distance;

        public TreeInfo(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
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
