package list;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyArbitraryPointer {

    // O(n) time | O(n) space
    private static ArbitraryListNode deepCopy(ArbitraryListNode root) {
        if (root == null) return null;

        ArbitraryListNode dummy = new ArbitraryListNode();
        ArbitraryListNode currCopy = dummy;

        Map<ArbitraryListNode, ArbitraryListNode> map = new HashMap<>();

        ArbitraryListNode curr = root;
        while (curr != null) {
            ArbitraryListNode copy = map.getOrDefault(curr, new ArbitraryListNode(curr.val));
            map.put(curr, copy);
            copy.arbitrary = curr.arbitrary;

            currCopy.next = copy;
            currCopy = currCopy.next;
            curr = curr.next;
        }

        currCopy = dummy;
        while (currCopy != null) {
            if (currCopy.arbitrary != null) {
                ArbitraryListNode node = map.getOrDefault(currCopy.arbitrary, new ArbitraryListNode(currCopy.arbitrary.val));
                currCopy.arbitrary = node;
            }
            currCopy = currCopy.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ArbitraryListNode root = new ArbitraryListNode(1);
        var second = new ArbitraryListNode(2);
        var third = new ArbitraryListNode(3);
        var four = new ArbitraryListNode(4);
        var five = new ArbitraryListNode(5);

        root.next = second;
        second.next = third;
        third.next = four;
        four.next = five;

        second.arbitrary = five;
        third.arbitrary = root;
        five.arbitrary = second;


        ArbitraryListNode copy = deepCopy(root);

        assertArbitraryListNode(root, copy);
    }

    private static void assertArbitraryListNode(ArbitraryListNode root, ArbitraryListNode copy) {
        var c1 = root;
        var c2 = copy;

        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) throw new IllegalStateException(c1.val + " != " + c2.val);
            if (c1 == c2) throw new IllegalStateException(c1 + " " + c2);
            if (c1.arbitrary == null && c2.arbitrary != null) throw new IllegalStateException(c1.arbitrary + " != " + c2.arbitrary);
            if (c1.arbitrary != null && c2.arbitrary == null) throw new IllegalStateException(c1.arbitrary + " != " + c2.arbitrary);
            if (c1.arbitrary != null && c1.arbitrary.val != c2.arbitrary.val) throw new IllegalStateException(c1.arbitrary + " != " + c2.arbitrary);
            if (c1.arbitrary != null && c1.arbitrary == c2.arbitrary) throw new IllegalStateException(c1.arbitrary + " == " + c2.arbitrary);

            c1 = c1.next;
            c2 = c2.next;
        }
        if (c1 != null || c2 != null) throw new IllegalStateException(c1 + " != " + c2);
    }
}
