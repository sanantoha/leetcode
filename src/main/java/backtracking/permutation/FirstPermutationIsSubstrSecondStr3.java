package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr3 {

    private static List<String> permute(String src) {
        List<String> result = new ArrayList<>();
        backtrack(src, "", result);
        return result;
    }

    private static void backtrack(String src, String ans, List<String> result) {
        if (src.isEmpty()) {
            result.add(ans);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            String rem = src.substring(0, i) + src.substring(i + 1);
            backtrack(rem, ans + c, result);
        }
    }

    public static boolean findPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        List<String> permutations = permute(s1);
        for (String perm : permutations) {
            if (s2.contains(perm)) return true;
        }
        return false;
    }

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
        for (int i : alphas) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation1("abc", "hdflebacworld"));

        System.out.println(findPermutation1("abbc", "hbbcadflebdworld"));
    }
}
