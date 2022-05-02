package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubsequence4 {

    // O(s1 * s2 * min(s1, s2)) time | O(s1 * s2 * min(s1, s2)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) return Collections.emptyList();

        List<Character>[][] lcs = new List[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                lcs[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    var lst = new ArrayList<>(lcs[i - 1][j - 1]);
                    lst.add(str1.charAt(i - 1));
                    lcs[i][j] = lst;
                } else {
                    List<Character> lst = null;
                    if (lcs[i - 1][j].size() > lcs[i][j - 1].size()) {
                        lst = new ArrayList<>(lcs[i - 1][j]);
                    } else {
                        lst = new ArrayList<>(lcs[i][j - 1]);
                    }
                    lcs[i][j] = lst;
                }
            }
        }

        return lcs[str1.length()][str2.length()];
    }

    // O(s1 * s2) time | O(s1 * s2) space
    public static List<Character> longestCommonSubsequence1(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) return Collections.emptyList();

        Info[][] lcs = new Info[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                lcs[i][j] = new Info();
            }
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = new Info(i - 1, j - 1, lcs[i][j].len + 1, str1.charAt(i - 1));
                } else {
                    if (lcs[i - 1][j].len > lcs[i][j - 1].len) {
                        lcs[i][j] = new Info(i - 1, j, lcs[i - 1][j].len, ' ');
                    } else {
                        lcs[i][j] = new Info(i, j - 1, lcs[i][j - 1].len, ' ');
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
            if (info.c != ' ') res.add(info.c);
            i = info.prevX;
            j = info.prevY;
        }

        Collections.reverse(res);
        return res;
    }

    static class Info {
        int prevX = -1;
        int prevY = -1;
        int len = 0;
        char c = ' ';

        public Info() {
        }

        public Info(int prevX, int prevY, int len, char c) {
            this.prevX = prevX;
            this.prevY = prevY;
            this.len = len;
            this.c = c;
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
