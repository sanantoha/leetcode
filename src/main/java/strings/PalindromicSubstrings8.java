package strings;

public class PalindromicSubstrings8 {

    private static int countPalindrom(String str, int l, int r) {
        int count = 0;
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) != str.charAt(r)) break;
            count++;
            l--;
            r++;
        }

        return count;
    }

    public static int countSubstrings(String str) {
        int count = 0;
        if (str == null || str.length() == 0) return count;

        for (int i = 0; i < str.length(); i++) {
            count += countPalindrom(str, i, i);
            count += countPalindrom(str, i, i + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
        System.out.println(countSubstrings("aabbbaa"));
    }
}
