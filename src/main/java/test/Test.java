package test;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> easyTasks = List.of(
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
                "SameBSTs",
                "LowestCommonAncestorOfBinarySearchTree",
                "ValidateBinarySearchTree",
                "SameTree",
                "FirstDuplicateValue"
        );

        List<String> middleTasks = List.of(
                "OptimalFreelancing",
                "Permutations",
                "ProductOfArrayExceptSelf",
                "ReverseWordsInString",
                "RemoveNthNodeFromEndOfList",
                "SubarraySumEqualsK",
                "MergeIntervals",
                "Sqrt",
                "CountingSort",
                "DFSTreeTraverseRec",
                "BreadthSearchFirst",
                "UniquePaths",
                "BinaryTreeDiameter",
                "DepthFirstSearch",
                "ReverseBinaryTree",
                "ReverseLinkedList",
                "KthSmallestElementInArray",
                "BSTSuccessorSearch",
                "RotateArray",
                "NodeDepths",
                "WordBreak",
                "CombinationSum",
                "MinSwapsTransformStringToPalindrome"
        );

        List<String> hardTasks = List.of(
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
                "StringWithoutAAAorBBB",
                "MergeSort",
                "CloneGraph",
                "MinHeap",
                "QuickSort",
                "Powerset",
                "MinimumWindowSubstring",
                "RiverSizes",
                "ConstructBinaryTreeFromPreorderAndInorderTraversal",
                "RegularExpressionMatch",
                "SubarraySort",
                "ThreeSum",
                "UniquePathIII",
                "ValidateStartingCity",
                "WordLadder",
                "PrimMinSpanningTree",
                "NumberOfIsland",
                "ValidIPAddress",
                "MedianOfTwoSortedArrays",
                "StableInternships",
                "LevenshteinDistance",
                "KruskalMinSpanningTree",
                "MaxSumIncreasingSubsequence",
                "LongestIncrSubSeq",
                "LongestIncreasingPathInMatrix",
                "LargestIsland",
                "TopologicalSort",
                "MinimumPassesOfMatrix",
                "HeapSort",
                "LongestDecrSubseq"
        );
        /*
            LeftViewBinaryTree
            SearchInRotatedSortedArray
            SurroundedRegions
            SpiralMatrixTraverse
            ProductOfArrayExceptSelf
            DeleteNodeInLinkedList
            ReverseWordsInString
            BellmanFordAsMap
            RemoveNthNodeFromEndOfList
            MinRewards
            IntersectionLinkedList
            LRUCache
            SubarraySumEqualsK
            StringWithoutAAAorBBB
            MiddleNode
            MergeSort
            CloneGraph
            MinHeap
            FindPivotIndex
            QuickSort
            Powerset
            AddTwoNumbers
            MinimumWindowSubstring
            MergeIntervals
            RiverSizes
            ConstructBinaryTreeFromPreorderAndInorderTraversal
            Sqrt
            RegularExpressionMatch
            CountingSort
            DFSTreeTraverseRec
            SubarraySort
            UniquePathIII
            BreadthSearchFirst
            ValidateStartingCity
            HouseRobber
            WordLadder
            BFSTreeTraverse
            PrimMinSpanningTree
            UniquePaths
            BinaryTreeDiameter
            NumberOfIsland
            ValidIPAddress
            PopulatingNextRightPointerInEachNode
            MedianOfTwoSortedArrays
            BinaryTreeZigzagLevelOrderTraverse
            DepthFirstSearch
            ReverseBinaryTree
            ReverseLinkedList
            StableInternships
            BinarySearch
            LevenshteinDistance
            BalancedBinaryTree
            KthSmallestElementInArray
            BestTimeToBuyAndSellStock
            KruskalMinSpanningTree
            BSTSuccessorSearch
            SameBSTs
            MaxSumIncreasingSubsequence
            RotateArray
            NodeDepths
            WordBreak
            CombinationSum
            LowestCommonAncestorOfBinarySearchTree
            LongestIncrSubSeq
            ValidateBinarySearchTree
            LongestIncreasingPathInMatrix
            SameTree
            LargestIsland
            FirstDuplicateValue
            TopologicalSort
            MinimumPassesOfMatrix
            HeapSort
            MinSwapsTransformStringToPalindrome
            LongestDecrSubseq
            AllElementsInTwoBinarySearchTrees
            BellmanFord
            BranchSums
            FirstPermutationIsSubstrSecondStr
            GenerateParentheses
            WaterArea
            InsertSort
            AllPathsFromSourceTarget
            FindClosestValueInBST
            ZigZagTraverse
            PalindromeLinkedList
            TopologicalSortDFSCycleGraph
            MinNumberOfCoinsForChange
            DijkstraShortestPathsAsMap
            TopKFrequentWords
            MinimalHeaviestSetA
            FindNodesDistanceK
            StringPermutation
            LongestNonDecrSubseq
            FirstUniqueCharacterInString
            DFSTreeTraverse
            MergeBinaryTrees
            DeepCopyArbitraryPointer
            SymmetricTree
            CycleLinkedList
            KruskalMinSpanningTreeAsMap
            DiskStacking
            LargestRange
            LowestCommonAncestorOfBinaryTree
            SelectSort
            AStarAlgo
            ReconstructBST
            DepthFirstSearchAsMap
            FourSum
            NumberOfWaysToMakeChange
            WordSearch
            ClimbingStairs
            NextGreaterElement
            EvaluateExpressionTree
            ConvertedSortedArrayToBST
            StaircaseTraversal
            MergedTwoSortedLists
            SortKSortedArray
            TopologicalSortDFSCycleGraphAsMap
            ReverseInteger
            LongestCommonSubsequence
            PalindromicSubstrings
            DijkstraShortestPaths
            SearchForRange
            RotateImage
            OneEdit
            PrimMinSpanningTreeAsMap
            Pow
            SortList
            PhoneNumberMnemonic
            KnapsackProblem
            ReverseString
            ----------------
            BreadthSearchFirstAsMap
            MaximumSubarray
            SparseMatrixMultiplication
            OptimalFreelancing
            ThreeSum
            BalancedBrackets
            WordLadderII
            Permutations
            MaxPathSumInBinaryTree
            MinNumberOfJumps
         */

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
    }
}