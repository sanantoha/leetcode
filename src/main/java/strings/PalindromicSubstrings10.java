package strings;

public class PalindromicSubstrings10 {

    // O(n ^ 2) time | O(1) space
    public static int countSubstrings(String src) {
        int count = 0;
        if (src == null) return count;

        for (int i = 0; i < src.length(); i++) {
            count += countPalindrom(src, i, i);
            count += countPalindrom(src, i, i + 1);
        }
        return count;
    }

    private static int countPalindrom(String src, int l, int r) {
        int count = 0;

        while (l >= 0 && r < src.length()) {
            if (src.charAt(l) != src.charAt(r)) break;
            count++;
            l--;
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
        System.out.println(countSubstrings("aabbbaa"));
    }
}
