package list;

public class DeepCopyArbitraryPointer1 {

    private static ArbitraryListNode deepCopy(ArbitraryListNode root) {
        return null;
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
