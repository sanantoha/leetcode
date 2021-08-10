package test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        /*
            SortList
            LongestDecrSubseq4
            TopologicalSortDFSCycleGraph3
            ReverseLinkedList
            StaircaseTraversal
            ProductOfArrayExceptSelf
            LowestCommonAncestorOfBinarySearchTree3
            DFSTreeTraverse
            SearchForRange
            LowestCommonAncestorOfBinaryTree
            MedianOfTwoSortedArrays
            Powerset
            DFSTreeTraverseRec
            FourSome
            SameTree5
            PhoneNumberMnemonic3
            BFSTreeTraverse
            LongestIncrSubSeq5
            LongestNonDecrSubseq3
            LargestRange
            MergeIntervals
            ThreeSum
            MinRewards1
            PalindromicSubstrings
            PopulatingNextRightPointerInEachNode
            MaximumSubarray
         */

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(new Tree(0, "tree0"), 1));
        queue.add(new Item(new Tree(1, "tree1"), 2));

        System.out.println(queue.peek());
        System.out.println(queue);
    }

    static class Tree {

        int i;
        String value;

        Tree(int i, String value) {
            this.i = i;
            this.value = value;
        }

        public int getI() {
            return i;
        }

        public String getValue() {
            return value;
        }
    }

    static class Item {
        Tree tree;
        int cnt;

        public Item(Tree tree, int cnt) {
            this.tree = tree;
            this.cnt = cnt;
        }

        public Tree getTree() {
            return tree;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
