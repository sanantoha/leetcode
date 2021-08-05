package top.interview.question.medium.array_strings;

class Solution4 {

    public String palindrome(String s, int lo, int hi) {
        int i = lo;
        int j = hi;
        while (i < hi && j >= 0) {
            if (i == j) break;
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (l == r) {
                i++;
                j--;
            } else return "";
        }
        return s.substring(lo, hi + 1);
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";

        String max = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String p = palindrome(s, j, i);
                if (!p.isEmpty() && max.length() < p.length()) {
                    max = p;
                    break;
                }
            }
        }

        return max;
    }
}

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        // 0 1 2 3 4
        // b a b a d
        System.out.println(s.longestPalindrome("bababd"));

        System.out.println(s.longestPalindrome("cbbd"));
    }
}
