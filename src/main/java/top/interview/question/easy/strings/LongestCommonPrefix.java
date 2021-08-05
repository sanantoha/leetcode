package top.interview.question.easy.strings;

class Solution8 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (!s.startsWith(first)) {
                first = first.substring(0, first.length() - 1);
                if (first.isEmpty()) return "";
            }
        }
        return first;
    }
}

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution8 s = new Solution8();

        String[] strs = {"flower","flow","flight"};
//        String[] strs = {""};

        System.out.println(s.longestCommonPrefix(strs));
    }
}
