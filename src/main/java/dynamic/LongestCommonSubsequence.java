package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Longest%20Common%20Subsequence
 */
public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        return new ArrayList<Character>();
    }

    public static List<Character> longestCommonSubsequence1(String str1, String str2) {
        // Write your code here.
        return new ArrayList<Character>();
    }

    public static void main(String[] args) {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        System.out.println(compare(longestCommonSubsequence("ZXVVYZW", "XKYKZPW"), expected));
    }

    private static boolean compare(List<Character> arr1, char[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
