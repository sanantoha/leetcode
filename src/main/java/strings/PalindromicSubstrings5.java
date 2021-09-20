package strings;

public class PalindromicSubstrings5 {

    private static int countPalindrome(String src, int l, int r) {
        int count = 0;
        while (l >= 0 && r < src.length()) {
            if (src.charAt(l) != src.charAt(r)) break;
            count++;
            l--;
            r++;
        }
        return count;
    }

    // O(n ^ 2) time | O(1) space
    public static int countSubstrings(String src) {
        int count = 0;
        if (src == null || src.isEmpty()) return count;

        for (int i = 0; i < src.length(); i++) {
            count += countPalindrome(src, i, i);
            count += countPalindrome(src, i, i + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
        System.out.println(countSubstrings("aabbbaa"));
    }
}
