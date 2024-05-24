package test;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
                "HouseRobber",
                "GreatestCommonDivisor",
                "BFSTreeTraverse",
                "PopulatingNextRightPointerInEachNode",
                "BinaryTreeZigzagLevelOrderTraverse",
                "BinarySearch",
                "BalancedBinaryTree",
                "BestTimeToBuyAndSellStock",
                "ValidateBinarySearchTree",
                "SameTree",
                "FirstDuplicateValue",
                "FirstUniqueCharacterInString",
                "SymmetricTree",
                "CycleLinkedList",
                "LowestCommonAncestorOfBinaryTree",
                "SelectSort",
                "LowestCommonAncestorOfBinarySearchTree",
                "NumberOfWaysToMakeChange",
                "ClimbingStairs",
                "ConvertedSortedArrayToBST",
                "ReverseInteger",
                "Pow",
                "InsertSort",
                "ReverseString",
                "MaximumSubarray",
                "BreadthSearchFirstAsMap",
                "BalancedBrackets",
                "LeftViewBinaryTree",
                "DeleteNodeInLinkedList",
                "IntersectionLinkedList",
                "MiddleNode",
                "FindPivotIndex",
                "AddTwoNumbers"
        );

        List<String> medium = List.of(
                "RotateArray",
                "FindPeakElement",
                "NodeDepths",
                "LevelOrderBinaryTreeTraverse",
                "WordBreak",
                "EvaluateExpressionTree",
                "CombinationSum",
                "SubarraySumEqualsK",
                "MergedTwoSortedLists",
                "MinSwapsTransformStringToPalindrome",
                "BranchSums",
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
                "InsertGreatestCommonDivisors",
                "OptimalFreelancing",
                "Permutations",
                "ProductOfArrayExceptSelf",
                "ReverseWordsInString",
                "RemoveNthNodeFromEndOfList",
                "GenerateParentheses",
                "StringWithoutAAAorBBB",
                "MergeIntervals",
                "Sqrt",
                "QuickSort",
                "CountingSort",
                "DFSTreeTraverseRec",
                "BreadthSearchFirst",
                "UniquePaths",
                "BinaryTreeDiameter",
                "DepthFirstSearch",
                "ReverseBinaryTree",
                "ReverseLinkedList",
                "KthSmallestElementInArray",
                "Search2DMatrix",
                "KthSmallestElementInBST",
                "BSTSuccessorSearch"
        );

        List<String> hardTasks = List.of(
                "RotateImage",
                "PrimMinSpanningTreeAsMap",
                "SortList",
                "PhoneNumberMnemonic",
                "KnapsackProblem",
                "SparseMatrixMultiplication",
                "WordLadderII",
                "MaxPathSumInBinaryTree",
                "MinNumberOfJumps",
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
                "MinimumWindowSubstring",
                "RiverSizes",
                "SameBSTs",
                "LRUCache",
                "ThreeSum",
                "ConstructBinaryTreeFromPreorderAndInorderTraversal",
                "UniquePathIII",
                "ValidateStartingCity",
                "WordLadder",
                "PrimMinSpanningTree",
                "NumberOfIsland",
                "ValidIPAddress",
                "RegularExpressionMatch",
                "SubarraySort",
                "MedianOfTwoSortedArrays",
                "StableInternships",
                "LevenshteinDistance",
                "KruskalMinSpanningTree",
                "MaxSumIncreasingSubsequence",
                "LongestIncrSubSeq",
                "LongestIncreasingPathInMatrix",
                "TopologicalSort",
                "MinimumPassesOfMatrix",
                "HeapSort",
                "LongestDecrSubseq",
                "AllElementsInTwoBinarySearchTrees",
                "BellmanFord",
                "FirstPermutationIsSubstrSecondStr",
                "WaterArea",
                "AllPathsFromSourceTarget",
                "ZigZagTraverse",
                "TopologicalSortDFSCycleGraph",
                "DijkstraShortestPathsAsMap",
                "FindNodesDistanceK",
                "LongestNonDecrSubseq",
                "MergeBinaryTrees",
                "KruskalMinSpanningTreeAsMap",
                "DeepCopyArbitraryPointer",
                "DiskStacking",
                "OddEvenLinkedList",
                "TopKFrequentWords",
                "LargestRange",
                "AStarAlgo",
                "FourSum",
                "WordSearch",
                "NextGreaterElement",
                "StaircaseTraversal",
                "TopologicalSortDFSCycleGraphAsMap",
                "LongestCommonSubsequence",
                "DijkstraShortestPaths",
                "SearchForRange"
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
        
        System.out.println("easy tasks: " + easyTasks.size());
        System.out.println("medium tasks: " + medium.size());
        System.out.println("hard tasks: " + hardTasks.size());
        System.out.println("total tasks: " + (easyTasks.size() + medium.size() + hardTasks.size()));
    }
}