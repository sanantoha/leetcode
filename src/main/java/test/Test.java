package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

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
            WaterArea
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
            MergeBinaryTrees
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
            SparseMatrixMultiplication
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
            StableInternships
            BinarySearch
            LevenshteinDistance
            BalancedBinaryTree
            KthSmallestElementInArray
            BestTimeToBuyAndSellStock
            KruskalMinSpanningTree
            BSTSuccessorSearch
            SameBSTs
            RotateArray
            NodeDepths
            WordBreak
            CombinationSum
            LowestCommonAncestorOfBinarySearchTree
            LongestIncrSubSeq
            ValidateBinarySearchTree
            LongestIncreasingPathInMatrix
            SameTree
         */

//        var p = new Person("Ivan", 12, new Address("35th Avenue", "New York"));
//        System.out.println(p);
//        print(p);

//        CompletableFuture.supplyAsync()
        ConcurrentMap<String, String> map = new ConcurrentSkipListMap<>();
        map.put("key", "valueOld");
        String key = "key";
        String oldVal = map.computeIfAbsent(key, k -> {
            return "value";
        });

        System.out.println(oldVal);
        System.out.println(map);

        String oldVal1 = map.computeIfAbsent(key, k -> {
            return "value1";
        });
        System.out.println(oldVal1);
        System.out.println(map);

        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "test");
        mp.get(1);

        int i = 65538;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >>> 16));
//        System.out.println(1 << 16);
        System.out.println("------");
        System.out.println(i >>> 16);
        System.out.println(i ^ (i >>> 16));
        System.out.println(0 ^ 1);
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