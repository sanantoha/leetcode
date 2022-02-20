package dynamic;

public class LevenshteinDistance4 {

    // O(s1 * s2) time | O(s1 * s2) space
    public static int levenshteinDistance(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) return 0;
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < distance.length; i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i < distance[0].length; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i < distance.length; i++) {
            for (int j = 1; j < distance[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = 1 + Math.min(Math.min(distance[i - 1][j], distance[i][j - 1]),
                            distance[i - 1][j - 1]);
                }
            }
        }
        return distance[str1.length()][str2.length()];
    }

    // O(s1 * s2) time | O(min(s1, s2)) space
    public static int levenshteinDistance1(String str1, String str2) {
        if ((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0)) return 0;
        if (str1 == null || str1.length() == 0) return str2.length();
        if (str2 == null || str2.length() == 0) return str1.length();

        String small = (str1.length() <= str2.length()) ? str1 : str2;
        String big = (str1.length() > str2.length()) ? str1 : str2;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i < even.length; i++) {
            even[i] = i;
        }

        int[] odd = new int[small.length() + 1];
        int[] prev = even;
        int[] curr = odd;

        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 0) {
                curr = even;
                prev = odd;
            } else {
                curr = odd;
                prev = even;
            }
            curr[0] = i;
            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(Math.min(prev[j - 1], prev[j]), curr[j - 1]);
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
