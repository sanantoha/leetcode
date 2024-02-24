package test;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
                "FirstUniqueCharacterInString",
                "SymmetricTree",
                "CycleLinkedList",
                "LowestCommonAncestorOfBinaryTree",
                "SelectSort",
                "NumberOfWaysToMakeChange",
                "ClimbingStairs",
                "ConvertedSortedArrayToBST",
                "ReverseInteger",
                "Pow",
                "GreatestCommonDivisor",
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
                "AddTwoNumbers",
                "HouseRobber",
                "BFSTreeTraverse",
                "PopulatingNextRightPointerInEachNode",
                "BinaryTreeZigzagLevelOrderTraverse",
                "BinarySearch",
                "BalancedBinaryTree",
                "BestTimeToBuyAndSellStock",
                "LowestCommonAncestorOfBinarySearchTree",
                "ValidateBinarySearchTree",
                "SameTree",
                "FirstDuplicateValue"
        );

        List<String> medium = List.of(
                "KthSmallestElementInArray",
                "BSTSuccessorSearch",
                "RotateArray",
                "NodeDepths",
                "WordBreak",
                "CombinationSum",
                "InsertGreatestCommonDivisors",
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
                "OptimalFreelancing",
                "Permutations",
                "ProductOfArrayExceptSelf",
                "ReverseWordsInString",
                "RemoveNthNodeFromEndOfList",
                "GenerateParentheses",
                "SubarraySumEqualsK",
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
                "ReverseLinkedList"
        );

        List<String> hardTasks = List.of(
                "LargestRange",
                "AStarAlgo",
                "ReconstructBST",
                "FourSum",
                "WordSearch",
                "NextGreaterElement",
                "EvaluateExpressionTree",
                "StaircaseTraversal",
                "MergedTwoSortedLists",
                "TopologicalSortDFSCycleGraphAsMap",
                "LongestCommonSubsequence",
                "DijkstraShortestPaths",
                "SearchForRange",
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
                "MinRewards",
                "LRUCache",
                "MergeSort",
                "CloneGraph",
                "LargestIsland",
                "MinHeap",
                "Powerset",
                "MinimumWindowSubstring",
                "RiverSizes",
                "ConstructBinaryTreeFromPreorderAndInorderTraversal",
                "RegularExpressionMatch",
                "SameBSTs",
                "ThreeSum",
                "UniquePathIII",
                "ValidateStartingCity",
                "WordLadder",
                "PrimMinSpanningTree",
                "NumberOfIsland",
                "ValidIPAddress",
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
                "TopKFrequentWords"
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