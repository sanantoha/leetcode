package top.interview.question.medium.array_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public int lengthOfLongestSubstring0(String s) {
        if (s.isEmpty()) return 0;

        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i] = dp[i] + 1;
                } else {
                    dp[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        int max = 0;
        for (int k : dp) {
            max = Math.max(max, k);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;


        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j) && !set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    max = Math.max(max, set.size());
                    break;
                }
            }
            max = Math.max(max, set.size());
            set.clear();
        }

        return max;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        // a b c a b c d b b
        String str = "abcabcdbb";

//        String str = "";

        System.out.println(s.lengthOfLongestSubstring(str));

    }
}
