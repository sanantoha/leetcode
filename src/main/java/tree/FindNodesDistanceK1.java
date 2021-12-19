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

    static class TreeInfo {
        BinaryTree tree;
        int distance;

        public TreeInfo(BinaryTree tree, int distance) {
            this.tree = tree;
            this.distance = distance;
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(tree, null, parents);

        BinaryTree targetNode = getNodeByValue(tree, parents, target);

        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(targetNode, 0));
        Set<Integer> seen = new HashSet<>();
        seen.add(target);

        while (!queue.isEmpty()) {
            TreeInfo ti = queue.remove();
            BinaryTree curr = ti.tree;
            int distance = ti.distance;

            if (distance == k) {
                List<Integer> res = new ArrayList<>();
                res.add(curr.value);
                while (!queue.isEmpty()) {
                    res.add(queue.remove().tree.value);
                }
                return res;
            }


            List<BinaryTree> nodes = Arrays.asList(curr.left, curr.right, parents.get(curr.value));
            for (BinaryTree node : nodes) {
                if (node == null) continue;
                if (seen.contains(node.value)) continue;
                seen.add(node.value);
                queue.add(new TreeInfo(node, distance + 1));
            }
        }

        return new ArrayList<>();
    }

    private static void enrichParents(BinaryTree tree, BinaryTree parent, Map<Integer, BinaryTree> parents) {
        if (tree != null) {
            parents.put(tree.value, parent);
            enrichParents(tree.left, tree, parents);
            enrichParents(tree.right, tree, parents);
        }
    }

    private static BinaryTree getNodeByValue(BinaryTree tree, Map<Integer, BinaryTree> parents, int val) {
        if (tree.value == val) return tree;

        BinaryTree parent = parents.get(val);
        if (parent != null && parent.left.value == val) return parent.left;
        else return parent.right;
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodesDistanceKRec(BinaryTree tree, int target, int k) {
        if (tree == null || k < 0) return Collections.emptyList();

        Map<Integer, BinaryTree> parents = new HashMap<>();
        enrichParents(tree, null, parents);

        BinaryTree targetNode = getNodeByValue(tree, parents, target);
        Set<Integer> seen = new HashSet<>();
        List<Integer> distanceK = new ArrayList<>();

        enrichDistanceK(targetNode, parents, seen, 0, k, distanceK);

        return distanceK;
    }

    private static void enrichDistanceK(BinaryTree tree, Map<Integer, BinaryTree> parents, Set<Integer> seen, int distance, int k, List<Integer> distanceK) {
        if (tree == null || seen.contains(tree.value)) return;

        seen.add(tree.value);

        if (distance == k) {
            distanceK.add(tree.value);
        } else {
            enrichDistanceK(tree.left, parents, seen, distance + 1, k, distanceK);
            enrichDistanceK(tree.right, parents, seen, distance + 1, k, distanceK);
            enrichDistanceK(parents.get(tree.value), parents, seen, distance + 1, k, distanceK);
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
