package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr4 {

    public static boolean findPermutation1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;

        for (String perm : permute(s1)) {
            if (s2.contains(perm)) return true;
        }
        return false;
    }

    private static List<String> permute(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, "", res);
        return res;
    }

    private static void backtrack(String s, String ans, List<String> res) {
        if (s.length() == 0) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String rem = s.substring(0, i) + s.substring(i + 1);
            backtrack(rem, ans + c, res);
        }
    }

    public static boolean findPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
        if (s1.length() > s2.length()) return false;

        int[] alphs = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            alphs[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            alphs[s2.charAt(i) - 'a']--;

            if (i >= s1.length()) alphs[s2.charAt(i - s1.length()) - 'a']++;
            if (allZeros(alphs)) return true;
        }
        return false;
    }

    private static boolean allZeros(int[] alphas) {
        for (int v : alphas) {
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
