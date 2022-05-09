package array;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        return null;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/2017/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC

        System.out.println(minWindow("a", "a")); // a

        System.out.println(minWindow("a", "aa")); // ""
    }
}
