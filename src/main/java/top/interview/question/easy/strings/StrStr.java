package top.interview.question.easy.strings;

class Solution6 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int j = 0;
        int k = needle.length() - 1;
        int res = -1;
        for (int i = 0; i < haystack.length(); i++) {
            char l = haystack.charAt(i);
            char r = needle.charAt(j);
            if (j <= k && l == r) {
                if (res < 0) res = i;
                if (j == k) return res;
                j++;
            } else if (j != 0) {
                i -= j;
                j = 0;
                res = -1;
            }
        }
        return -1;
    }
}

public class StrStr {
    public static void main(String[] args) {
        Solution6 s = new Solution6();

//        String haystack = "hello", needle = "ll";
        String haystack = "mississippi"; // needle = "issi";
        String needle = "pi";
        System.out.println(s.strStr(haystack, needle));

    }
}
