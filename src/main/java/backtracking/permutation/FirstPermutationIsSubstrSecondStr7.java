package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr7 {

    // O(s1 ^ 2 * s1! + s1! * s2) time | O(s1 * s1!) space
    public static boolean findPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (String perm : permute(s1)) {
            if (s2.contains(perm)) return true; // O(s2)
        }
        return false;
    }

    // O(n ^ 2 * n!) time | O(n * n!) space
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
            String rem = src.substring(0, i) + src.substring(i + 1);
            backtrack(rem, ans + src.charAt(i), res);
        }
    }

    // O(s1 + s2) time | O(1) space
    public static boolean findPermutation1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] alphas = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphas[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            alphas[s2.charAt(i) - 'a']--;

            if (i >= s1.length()) alphas[s2.charAt(i - s1.length()) - 'a']++;

            if (allZeros(alphas)) return true;
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
        System.out.println(findPermutation("abc", "hdflebacworld"));
        System.out.println(findPermutation1("abc", "hdflebacworld"));


        System.out.println(findPermutation("abbc", "hbbcadflebdworld"));
        System.out.println(findPermutation1("abbc", "hbbcadflebdworld"));
    }
}
