package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

public class FirstPermutationIsSubstrSecondStr8 {

    // (n ^ 2 * n! + s1! * s2) time | O(n ^ 2 * n!) space
    public static boolean findPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        for (String permute : permute(s1)) {
            if (s2.contains(permute)) return true;
        }
        return false;
    }

    // (s1 ^ 2 * s1!) time | O(s1 ^ 2 * s1!) space
    private static List<String> permute(String src) {
        List<String> permutes = new ArrayList<>();
        backtrack(src, "", permutes);
        return permutes;
    }

    private static void backtrack(String src, String ans, List<String> permutes) {
        if (src.isEmpty()) {
            permutes.add(ans);
            return;
        }

        for (int i = 0; i < src.length(); i++) {
            String remain = src.substring(0, i) + src.substring(i + 1);
            backtrack(remain, ans + src.charAt(i), permutes);
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

            if (s1.length() <= i) alphas[s2.charAt(i - s1.length()) - 'a']++;
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
