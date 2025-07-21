package test;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
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
                "ReverseInteger",
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
                "HouseRobber"
        );

        List<String> medium = List.of(
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
                "Search2DMatrix",
                "KthSmallestElementInBST",
                "BSTSuccessorSearch",
                "RotateArray",
                "NodeDepths",
                "InsertGreatestCommonDivisors",
                "LevelOrderBinaryTreeTraverse",
                "WordBreak",
                "EvaluateExpressionTree",
                "SubTreeOfAnotherTree",
                "CombinationSum"
        );

        List<String> hardTasks = List.of(
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
                "GenerateMatrix",
                "NextGreaterElement",
                "StaircaseTraversal",
                "TopologicalSortDFSCycleGraphAsMap",
                "LongestCommonSubsequence",
                "DijkstraShortestPaths",
                "SearchForRange",
                "RotateImage",
                "PrimMinSpanningTreeAsMap",
                "SortList",
                "PhoneNumberMnemonic"
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
