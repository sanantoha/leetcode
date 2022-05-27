package dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // O(n ^ 3) time | O(n) space
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/347/dynamic-programming/3137/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet","code"))); // true

        System.out.println(wordBreak("applepenapple", List.of("apple","pen"))); // true

        System.out.println(wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))); // false
    }
}
