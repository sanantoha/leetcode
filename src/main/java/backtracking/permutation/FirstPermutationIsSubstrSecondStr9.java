package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr9 {

    // O(s1 ^ 2 * s1! + s2 * s1!) time | O(s1 ^ 2 * s1!) space
    public static boolean findPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (String p : permute(s1)) {
            if (s2.contains(p)) return true;
        }
        return false;
    }

    private static List<String> permute(String str) {
        List<String> res = new ArrayList<>();
        backtrack(str, "", res);
        return res;
    }

    private static void backtrack(String str, String ans, List<String> res) {
        if (str.isEmpty()) {
            res.add(ans);
        }

        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            backtrack(rem, ans + str.charAt(i), res);
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
        for (int num : alphas) {
            if (num != 0) return false;
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
