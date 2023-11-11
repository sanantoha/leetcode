package test;

import java.util.Comparator;
import java.util.Objects;

public class Test {

    record Address(String street, String city) {}
    record Person(String name, int age, Address address) {}

    public static void print(Person person) {
        switch (person) {
            case Person(String name, int age, Address(String street, String city)) -> {
                System.out.println(String.format("name %s, age %s, street %s city %s", name, age, street, city));
            }
//            case Person p -> {
//                System.out.println(p.name);
//            }
            default -> System.out.println("default");
        }
    }

    public static void main(String[] args) {
        /*
            StableInternships
            KthSmallestElementInArray
            BestTimeToBuyAndSellStock
            KruskalMinSpanningTree
            BSTSuccessorSearch
            SameBSTs
            RotateArray
            WaterArea
            NodeDepths
            WordBreak
            SparseMatrixMultiplication
            CombinationSum
            MergeBinaryTrees
            LowestCommonAncestorOfBinarySearchTree
            LongestIncrSubSeq
            ValidateBinarySearchTree
            LongestIncreasingPathInMatrix
            SameTree
            LargestIsland
            FirstDuplicateValue
            MinimumPassesOfMatrix
            HeapSort
            MinSwapsTransformStringToPalindrome
            LongestDecrSubseq
            MaxSumIncreasingSubsequence
            AllElementsInTwoBinarySearchTrees
            BellmanFord
            BranchSums
            FirstPermutationIsSubstrSecondStr
            GenerateParentheses
            InsertSort
            AllPathsFromSourceTarget
            FindClosestValueInBST
            ZigZagTraverse
            PalindromeLinkedList
            TopologicalSortDFSCycleGraph
            DijkstraShortestPathsAsMap
            MinNumberOfCoinsForChange
            TopKFrequentWords
            MinimalHeaviestSetA
            SymmetricTree
            FindNodesDistanceK
            StringPermutation
            LongestNonDecrSubseq
            FirstUniqueCharacterInString
            DFSTreeTraverse
            DeepCopyArbitraryPointer
            PrimMinSpanningTreeAsMap
            CycleLinkedList
            KruskalMinSpanningTreeAsMap
            EvaluateExpressionTree
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
            ConvertedSortedArrayToBST
            StaircaseTraversal
            MergedTwoSortedLists
            SortKSortedArray
            TopologicalSortDFSCycleGraphAsMap
            ReverseInteger
            LongestCommonSubsequence
            DijkstraShortestPaths
            SearchForRange
            PalindromicSubstrings
            RotateImage
            OneEdit
            SortList
            PhoneNumberMnemonic
            Pow
            KnapsackProblem
            ReverseString
            BreadthSearchFirstAsMap
            MaximumSubarray
            ThreeSum
            BalancedBrackets
            WordLadderII
            Permutations
            MaxPathSumInBinaryTree
            MinNumberOfJumps
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
            BinarySearch
            LevenshteinDistance
            BalancedBinaryTree
         */

        var p = new Person("Ivan", 12, new Address("35th Avenue", "New York"));
        System.out.println(p);
        print(p);

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
        // simmetric x.equals(y) should return y.equals(x)
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