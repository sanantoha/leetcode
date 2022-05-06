package tree;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Find%20Nodes%20Distance%20K
 */
public class FindNodesDistanceK5 {

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
        Set<Integer> seen = new HashSet<>();
        seen.add(target);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(targetNode, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Pair p = queue.remove();
                BinaryTree curr = p.node;
                int level = p.level;
                if (level == k) {
                    res.add(curr.value);
                    while (!queue.isEmpty()) {
                        res.add(queue.remove().node.value);
                    }
                    return res;
                }

                List<BinaryTree> nodes = new ArrayList<>();
                nodes.add(curr.left);
                nodes.add(curr.right);
                nodes.add(parents.get(curr.value));

                for (BinaryTree node : nodes) {
                    if (node == null || seen.contains(node.value)) continue;
                    seen.add(node.value);
                    queue.add(new Pair(node, level + 1));
                }
            }

        }

        return res;
    }

    static class Pair {
        BinaryTree node;
        int level;

        public Pair(BinaryTree node, int level) {
            this.node = node;
            this.level = level;
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
        return parent.right;
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(tree, null, parents);

        BinaryTree targetNode = getNodeByValue(parents, tree, target);
        List<Integer> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        findNodes(targetNode, 0, k, parents, seen, res);
        return res;
    }

    private static void findNodes(BinaryTree node, int level, int k, Map<Integer, BinaryTree> parents, Set<Integer> seen, List<Integer> res) {
        if (node == null || seen.contains(node.value)) return;

        seen.add(node.value);

        if (level == k) {
            res.add(node.value);
        } else {
            findNodes(node.left, level + 1, k, parents, seen, res);
            findNodes(node.right, level + 1, k, parents, seen, res);
            findNodes(parents.get(node.value), level + 1, k, parents, seen, res);
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
