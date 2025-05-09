package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Longest%20Common%20Subsequence
 */
public class LongestCommonSubsequence {

    // O(s1 * s2 * min(s1, s2)) time | O(s1 * s2 * min(s1, s2)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
            return Collections.emptyList();

        List<List<List<Character>>> lcs = new ArrayList<>();
        for (int i = 0; i < str1.length() + 1; i++) {
            lcs.add(new ArrayList<>());
            for (int j = 0; j < str2.length() + 1; j++) {
                lcs.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 1; i < lcs.size(); i++) {
            for (int j = 1; j < lcs.get(i).size(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    List<Character> lst = new ArrayList<>(lcs.get(i - 1).get(j - 1));
                    lst.add(str1.charAt(i - 1));
                    lcs.get(i).set(j, lst);
                } else {
                    List<Character> left = new ArrayList<>(lcs.get(i - 1).get(j));
                    List<Character> up = new ArrayList<>(lcs.get(i).get(j - 1));

                    lcs.get(i).set(j, left.size() > up.size() ? left : up);
                }
            }
        }

        return lcs.get(str1.length()).get(str2.length());
    }

    // O(s1 * s2) time | O(s1 * s2) space
    public static List<Character> longestCommonSubsequence1(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
            return Collections.emptyList();

        Info[][] lcs = new Info[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < lcs.length; i++) {
            for (int j = 0; j < lcs[i].length; j++) {
                lcs[i][j] = new Info();
            }
        }

        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = new Info(str1.charAt(i - 1), lcs[i - 1][j - 1].len + 1, i - 1, j - 1);
                } else {
                    if (lcs[i - 1][j].len > lcs[i][j - 1].len) {
                        lcs[i][j] = new Info(' ', lcs[i - 1][j].len, i - 1, j);
                    } else {
                        lcs[i][j] = new Info(' ', lcs[i][j - 1].len, i, j - 1);
                    }
                }
            }
        }

        return buildSequence(lcs);
    }

    private static List<Character> buildSequence(Info[][] lcs) {
        List<Character> res = new ArrayList<>();
        int i = lcs.length - 1;
        int j = lcs[i].length - 1;
        while (i >= 0 && j >= 0) {
            Info info = lcs[i][j];
            if (info.c != ' ') {
                res.add(info.c);
            }
            i = info.prevX;
            j = info.prevY;
        }
        Collections.reverse(res);
        return res;
    }

    static class Info {
        char c = ' ';
        int len = 0;
        int prevX = -1;
        int prevY = -1;

        public Info(char c, int len, int x, int y) {
            this.c = c;
            this.len = len;
            this.prevX = x;
            this.prevY = y;
        }

        public Info() {
        }
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
