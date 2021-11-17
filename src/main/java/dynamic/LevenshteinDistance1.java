package dynamic;

import java.util.Arrays;

public class LevenshteinDistance1 {

    // O(w * h) time | O(w * h) space
    public static int levenshteinDistance(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) {
            return 0;
        }
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        int[][] distances = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str2.length(); i++) {
            distances[0][i] = i;
        }
        for (int i = 0; i <= str1.length(); i++) {
            distances[i][0] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    distances[i][j] =
                            1 + Math.min(Math.min(distances[i - 1][j], distances[i][j - 1]), distances[i - 1][j - 1]);
                }
            }
        }

        return distances[str1.length()][str2.length()];
    }

    // O(w * h) time | O(min(w, h)) space
    public static int levenshteinDistance1(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) {
            return 0;
        }
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        String big = (str1.length() > str2.length()) ? str1 : str2;
        String small = (str1.length() < str2.length()) ? str1 : str2;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i <= small.length(); i++) {
            even[i] = i;
        }
        int[] odd = new int[small.length() + 1];

        int[] current;
        int[] prev;

        for (int i = 1; i <= big.length(); i++) {
            if (i % 2 == 0) {
                current = even;
                prev = odd;
            } else {
                current = odd;
                prev = even;
            }
            current[0] = i;
            for (int j = 1; j <= small.length(); j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = 1 + Math.min(Math.min(current[j - 1], prev[j - 1]), prev[j]);
                }
            }
        }
        return (big.length() % 2 == 0) ? even[small.length()] : odd[small.length()];
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd") == 2);
        System.out.println(levenshteinDistance1("abc", "yabd") == 2);
    }
}
