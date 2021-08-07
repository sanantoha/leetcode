package test;

import java.util.*;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        /*
            StaircaseTraversal
            MergeIntervals
            MinRewards - https://www.algoexpert.io/questions/Min%20Rewards
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
            FourSome
            SameTree5
            PhoneNumberMnemonic3
            BFSTreeTraverse
            LongestIncrSubSeq5
            LongestNonDecrSubseq3
            LargestRange
         */

        int[] arr = {1,2,3,4,5,6, 7};

        System.out.println(Arrays.stream(arr).sum());

        System.out.println(IntStream.of(arr).sum());

        PriorityQueue<int[]> queue =
                new PriorityQueue(3, Comparator.comparingInt((int[] o) -> o[1]));

        queue.add(new int[] {1, 2});

        System.out.println(queue);
    }
}
