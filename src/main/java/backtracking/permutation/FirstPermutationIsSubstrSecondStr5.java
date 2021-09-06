package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr5 {

    public static boolean findPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() > s2.length()) return false;

        for (String perm : permute(s1)) {
            if (s2.contains(perm)) return true;
        }
        return false;
    }

    private static List<String> permute(String src) {
        List<String> res = new ArrayList<>();
        backtrack(src, "", res);
        return res;
    }

    private static void backtrack(String src, String ans, List<String> res) {
        if (src.isEmpty()) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            backtrack(src.substring(0, i) + src.substring(i + 1), ans + src.charAt(i), res);
        }
    }

    public static boolean findPermutation1(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() > s2.length()) return false;

        int[] alpha = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            alpha[s2.charAt(i) - 'a']--;

            if (i >= s1.length()) alpha[s2.charAt(i - s1.length()) - 'a']++;

            if (allZeros(alpha)) return true;
        }
        return false;
    }

    private static boolean allZeros(int[] alpha) {
        for (int v : alpha) {
            if (v != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation1("abc", "hdflebacworld"));
        System.out.println(findPermutation("abc", "hdflebacworld"));

        System.out.println(findPermutation1("abbc", "hbbcadflebdworld"));
        System.out.println(findPermutation("abbc", "hbbcadflebdworld"));
    }
}
