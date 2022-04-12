package dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/apple/347/dynamic-programming/3135/
 */
public class RegularExpressionMatch {

    public static boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();
        return dp(0, 0, s, p, memo);
    }

    private static boolean dp(int i, int j, String s, String p, Map<String, Boolean> memo) {
        boolean ans;
        if (!memo.containsKey(key(i, j))) {
            if (j == p.length()) {
                ans = i == s.length();
            } else {
                boolean firstMatch = i < s.length() && Set.of(s.charAt(i), '.').contains(p.charAt(j));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    ans = dp(i, j + 2, s, p, memo) || firstMatch && dp(i + 1, j, s, p, memo);
                } else {
                    ans = firstMatch && dp(i + 1, j + 1, s, p, memo);
                }
            }
            memo.put(key(i, j), ans);
        }
        return memo.get(key(i, j));
    }

    private static String key(int i, int j) {
        return String.format("%s_%s", i, j);
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));

        System.out.println(isMatch("aa", "a*"));

        System.out.println(isMatch("abcde", ".*"));

        System.out.println(isMatch("abcde", ".*de"));
    }
}
