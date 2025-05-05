package test;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
                "Pow",
                "MinimumAbsoluteDifferenceInBST",
                "ReverseString",
                "MaximumSubarray",
                "BreadthSearchFirstAsMap",
                "BalancedBrackets",
                "LeftViewBinaryTree",
                "DeleteNodeInLinkedList",
                "IntersectionLinkedList",
                "MiddleNode",
                "FindPivotIndex",
                "AddTwoNumbers",
                "HouseRobber",
                "BFSTreeTraverse",
                "PopulatingNextRightPointerInEachNode",
                "BinaryTreeZigzagLevelOrderTraverse",
                "BinarySearch",
                "BalancedBinaryTree",
                "BestTimeToBuyAndSellStock",
                "ValidateBinarySearchTree",
                "SameTree",
                "FirstDuplicateValue",
                "InsertSort",
                "FirstUniqueCharacterInString",
                "SymmetricTree",
                "CycleLinkedList",
                "LowestCommonAncestorOfBinaryTree",
                "SelectSort",
                "LowestCommonAncestorOfBinarySearchTree",
                "NumberOfWaysToMakeChange",
                "ClimbingStairs",
                "GreatestCommonDivisor",
                "ConvertedSortedArrayToBST",
                "ReverseInteger"
        );

        List<String> medium = List.of(
                "KthSmallestElementInBST",
                "BSTSuccessorSearch",
                "RotateArray",
                "NodeDepths",
                "InsertGreatestCommonDivisors",
                "LevelOrderBinaryTreeTraverse",
                "WordBreak",
                "EvaluateExpressionTree",
                "CombinationSum",
                "SubarraySumEqualsK",
                "MergedTwoSortedLists",
                "MinSwapsTransformStringToPalindrome",
                "BranchSums",
                "BinaryTreeTilt",
                "FindClosestValueInBST",
                "PalindromeLinkedList",
                "MinNumberOfCoinsForChange",
                "MinimalHeaviestSetA",
                "StringPermutation",
                "DFSTreeTraverse",
                "DepthFirstSearchAsMap",
                "SortKSortedArray",
                "PalindromicSubstrings",
                "OneEdit",
                "FindPeakElement",
                "OptimalFreelancing",
                "Permutations",
                "ReverseWordsInString",
                "RemoveNthNodeFromEndOfList",
                "GenerateParentheses",
                "StringWithoutAAAorBBB",
                "MergeIntervals",
                "Sqrt",
                "QuickSort",
                "ProductOfArrayExceptSelf",
                "CountingSort",
                "DFSTreeTraverseRec",
                "BreadthSearchFirst",
                "UniquePaths",
                "BinaryTreeDiameter",
                "DepthFirstSearch",
                "ReverseBinaryTree",
                "ReverseLinkedList",
                "KthSmallestElementInArray",
                "Search2DMatrix"
        );

        List<String> hardTasks = List.of(
                "NextGreaterElement",
                "StaircaseTraversal",
                "TopologicalSortDFSCycleGraphAsMap",
                "LongestCommonSubsequence",
                "DijkstraShortestPaths",
                "SearchForRange",
                "RotateImage",
                "PrimMinSpanningTreeAsMap",
                "SortList",
                "PhoneNumberMnemonic",
                "SparseMatrixMultiplication",
                "WordLadderII",
                "SearchInRotatedSortedArray",
                "SurroundedRegions",
                "SpiralMatrixTraverse",
                "BellmanFordAsMap",
                "ReconstructBST",
                "MinRewards",
                "MergeSort",
                "CloneGraph",
                "LargestIsland",
                "MinHeap",
                "Powerset",
                "MinNumberOfJumps",
                "MinimumWindowSubstring",
                "OddEvenLinkedList",
                "RiverSizes",
                "SameBSTs",
                "LRUCache",
                "ThreeSum",
                "UniquePathIII",
                "ValidateStartingCity",
                "KnapsackProblem",
                "ConstructBinaryTreeFromPreorderAndInorderTraversal",
                "WordLadder",
                "PrimMinSpanningTree",
                "ValidIPAddress",
                "RegularExpressionMatch",
                "NumberOfIsland",
                "SubarraySort",
                "MaxPathSumInBinaryTree",
                "FindModeInBst",
                "MedianOfTwoSortedArrays",
                "MaxSumIncreasingSubsequence",
                "KruskalMinSpanningTree",
                "LongestIncrSubSeq",
                "StableInternships",
                "LevenshteinDistance",
                "LongestIncreasingPathInMatrix",
                "TopologicalSort",
                "MinimumPassesOfMatrix",
                "HeapSort",
                "LongestDecrSubseq",
                "AllElementsInTwoBinarySearchTrees",
                "BellmanFord",
                "WaterArea",
                "AllPathsFromSourceTarget",
                "FirstPermutationIsSubstrSecondStr",
                "ZigZagTraverse",
                "TopologicalSortDFSCycleGraph",
                "DijkstraShortestPathsAsMap",
                "FindNodesDistanceK",
                "MergeBinaryTrees",
                "KruskalMinSpanningTreeAsMap",
                "TopKFrequentWords",
                "LargestRange",
                "LongestNonDecrSubseq",
                "FourSum",
                "DiskStacking",
                "DeepCopyArbitraryPointer",
                "WordSearch",
                "AStarAlgo",
                "GenerateMatrix"
        );

        /*
            getClass
            equals,
            hashCode,
            clone
            notify
            notifyAll
            wait
            wait(long timeout)
            toString
            finalize
         */
        // Equals contract
        // reflexive x.equals(x)
        // symmetric x.equals(y) should return y.equals(x)
        // transitive x.equals(y) && y.equals(z) then x.equals(z)
        // consistent
        // non null for any non null x then x.equals(null) should return false

        // hashCode contract
        // if equals return true, hashCode must return the same integer result
        // if equals return false, hashCode must not return the same integer but
        // better for hashmap performance to return different value.
        // consistency
//        new Object().hashCode()
        
//        System.out.println("easy tasks: " + easyTasks.size());
//        System.out.println("medium tasks: " + medium.size());
//        System.out.println("hard tasks: " + hardTasks.size());
//        System.out.println("total tasks: " + (easyTasks.size() + medium.size() + hardTasks.size()));

//        System.out.println(System.currentTimeMillis());
//        System.out.println(Instant.now());

//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Dubai"));
//        System.setProperty("user.timezone", "Asia/Dubai");

        // 2023-04-27 07:39:32.0
//        System.out.println(TimeZone.getDefault());
//        System.out.println(System.getProperty("user.timezone"));

//        long t = 1682581172000L;
//        Instant instant = Instant.ofEpochMilli(t); // 2024-01-08T00:00:00Z
//        ZonedDateTime utc = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);          // 2024-01-08T00:00Z
//        ZonedDateTime dubai = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Dubai"));
//        System.out.println(Instant.ofEpochMilli(t).atZone(ZoneId.of("UTC")));
//        System.out.println(Instant.ofEpochMilli(t).atZone(ZoneId.systemDefault()));
//        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(t), ZoneOffset.UTC));
//        System.out.println(utc);
//        System.out.println(dubai);

        long timestamp = Instant.now().toEpochMilli();
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(timestamp);
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.now().toEpochMilli());
        int randomBits = ThreadLocalRandom.current().nextInt(100);  // 0-99
        long uniqueValue = (timestamp / 100) * 100 + randomBits;
        System.out.println(uniqueValue);
    }
}
