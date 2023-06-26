package tree;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK1 {

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
        enrichParents(parents, null, tree);

        BinaryTree targetNode = getTargetNode(parents, tree, target);

        Set<BinaryTree> visited = new HashSet<>();
        visited.add(targetNode);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(targetNode, 0));

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int distance = p.distance;
            BinaryTree curr = p.node;

            if (distance == k) {
                res.add(curr.value);
                while (!queue.isEmpty()) {
                    res.add(queue.remove().node.value);
                }
                break;
            }

            List<BinaryTree> neighbors = new ArrayList<>();
            neighbors.add(curr.left);
            neighbors.add(curr.right);
            neighbors.add(parents.get(curr.value));

            for (BinaryTree node : neighbors) {
                if (node == null || visited.contains(node)) continue;

                queue.add(new Pair(node, distance + 1));
            }
        }
        return res;
    }

    static class Pair {
        BinaryTree node;
        int distance;

        public Pair(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(parents, null, tree);

        BinaryTree targetNode = getTargetNode(parents, tree, target);
        Set<BinaryTree> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        findNodes(targetNode, 0, k, parents, visited, res);
        return res;
    }

    private static void findNodes(BinaryTree node, int distance, int k, Map<Integer, BinaryTree> parents, Set<BinaryTree> visited, List<Integer> res) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        if (distance == k) {
            res.add(node.value);
        } else {
            findNodes(node.left, distance + 1, k, parents, visited, res);
            findNodes(node.right, distance + 1, k, parents, visited, res);
            findNodes(parents.get(node.value), distance + 1, k, parents, visited, res);
        }
    }

    private static BinaryTree getTargetNode(Map<Integer, BinaryTree> parents, BinaryTree tree, int target) {
        if (tree.value == target) return tree;

        BinaryTree parent = parents.get(target);
        if (parent != null && parent.left.value == target) return parent.left;
        return parent.right;
    }

    private static void enrichParents(Map<Integer, BinaryTree> parents, BinaryTree parent, BinaryTree tree) {
        if (tree == null) return;
        parents.put(tree.value, parent);
        enrichParents(parents, tree, tree.left);
        enrichParents(parents, tree, tree.right);
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
