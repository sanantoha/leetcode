package list;

public class ArbitraryListNode {
    int val;
    ArbitraryListNode next;
    ArbitraryListNode arbitrary;

    public ArbitraryListNode() {
    }

    public ArbitraryListNode(int val) {
        this.val = val;
    }

    public ArbitraryListNode(int val, ArbitraryListNode next) {
        this.val = val;
        this.next = next;
    }

    public ArbitraryListNode(int val, ArbitraryListNode arbitrary, ArbitraryListNode next) {
        this.val = val;
        this.next = next;
        this.arbitrary = arbitrary;
    }

    @Override
    public String toString() {
        return val + " " + ((arbitrary != null) ? arbitrary.val : "null") + " -> " + ((next != null) ? next.val : "null");
    }
}
