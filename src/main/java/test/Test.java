package test;

import java.util.*;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        /*
            SameTree
            PhoneNumberMnemonic
            BFSTreeTraverse
            LongestIncrSubSeq5
            LargestRange
            StaircaseTraversal
            MergeIntervals
            ReverseLinkedList
            PalindromSubstrings
            PopulatingNextRightPointerInEachNode
            SortList
            LongestDecrSubseq4
            TopologicalSortDFSCycleGraph3
            ProductOfArrayExceptSelf
            LowestCommonAncestorOfBinarySearchTree3
            DFSTreeTraverse
            SearchForRange
            LowestCommonAncestorOfBinaryTree
            MedianOfTwoSortedArrays
            Powerset
            DFSTreeTraverseRec
         */

        int[] arr = {1,2,3,4,5,6};

        System.out.println(Arrays.stream(arr).sum());

        System.out.println(IntStream.of(arr).sum());
    }
}
