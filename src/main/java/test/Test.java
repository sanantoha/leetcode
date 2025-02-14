package test;

import javax.imageio.stream.FileImageInputStream;
import java.time.Instant;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
                "SelectSort",
                "LowestCommonAncestorOfBinarySearchTree",
                "NumberOfWaysToMakeChange",
                "ClimbingStairs",
                "ConvertedSortedArrayToBST",
                "ReverseInteger",
                "Pow",
                "MinimumAbsoluteDifferenceInBST",
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
                "LowestCommonAncestorOfBinaryTree"
        );

        List<String> medium = List.of(
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
                "BSTSuccessorSearch",
                "RotateArray",
                "NodeDepths",
                "LevelOrderBinaryTreeTraverse",
                "WordBreak",
                "BinaryTreeTilt",
                "EvaluateExpressionTree",
                "CombinationSum",
                "SubarraySumEqualsK",
                "MergedTwoSortedLists",
                "MinSwapsTransformStringToPalindrome",
                "BranchSums",
                "FindClosestValueInBST"
        );

        List<String> hardTasks = List.of(
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
                "FindModeInBst",
                "MinNumberOfJumps",
                "SearchInRotatedSortedArray",
                "SurroundedRegions",
                "KnapsackProblem",
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
                "MaxPathSumInBinaryTree",
                "UniquePathIII",
                "ValidateStartingCity",
                "ConstructBinaryTreeFromPreorderAndInorderTraversal",
                "WordLadder",
                "PrimMinSpanningTree",
                "ValidIPAddress",
                "RegularExpressionMatch",
                "NumberOfIsland",
                "SubarraySort",
                "MedianOfTwoSortedArrays",
                "StableInternships",
                "LevenshteinDistance",
                "MaxSumIncreasingSubsequence",
                "KruskalMinSpanningTree",
                "LongestIncrSubSeq",
                "LongestIncreasingPathInMatrix",
                "TopologicalSort",
                "OddEvenLinkedList",
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
                "TopKFrequentWords",
                "LargestRange",
                "FourSum",
                "DiskStacking",
                "DeepCopyArbitraryPointer",
                "AStarAlgo",
                "WordSearch",
                "GenerateMatrix",
                "NextGreaterElement"
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

        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now());
    }
}
