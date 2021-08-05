package top.interview.question.easy.strings;

import java.util.Arrays;

class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return true;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr, tarr);
    }
}

public class ValidAnagram {
    public static void main(String[] args) {
        Solution3 ss = new Solution3();

        String s = "anagram", t = "nagaram";

        System.out.println(ss.isAnagram(s, t));
    }
}
