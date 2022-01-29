package dynamic;

import java.util.List;

public class LongestCommonSubsequence2 {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        return null;
    }

    public static List<Character> longestCommonSubsequence1(String str1, String str2) {
        return null;
    }

    public static void main(String[] args) {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        List<Character> actual = longestCommonSubsequence("ZXVVYZW", "XKYKZPW");
        System.out.println(actual);
        System.out.println(compare(actual, expected));

        List<Character> actual1 = longestCommonSubsequence1("ZXVVYZW", "XKYKZPW");
        System.out.println(actual1);
        System.out.println(compare(actual1, expected));
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
