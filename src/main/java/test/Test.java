package test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        /*
            Pow
            CombinationSum4
            CloneGraph
            SearchInRotatedSortedArray
            Powerset
            PhoneNumberMnemonic3
            MergeIntervals
            LRUCache
            MedianOfTwoSortedArrays

            DFSTreeTraverseRec
            FourSum
            BFSTreeTraverse
            LongestIncrSubSeq5
            LongestNonDecrSubseq3
            LargestRange
            ThreeSum
            LowestCommonAncestorOfBinaryTree4
            MinRewards1
            PopulatingNextRightPointerInEachNode
            SortList
            LongestDecrSubseq4
            TopologicalSortDFSCycleGraph3
            ReverseLinkedList
            StaircaseTraversal
            ProductOfArrayExceptSelf
            LowestCommonAncestorOfBinarySearchTree3
            SameTree
            SymmetricTree2
            DFSTreeTraverse
            SearchForRange
            ReverseBinaryTree7
            PalindromicSubstrings
            ReverseWordsInString2
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
