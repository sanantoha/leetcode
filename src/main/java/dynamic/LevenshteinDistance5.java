package dynamic;

public class LevenshteinDistance5 {

    // O(n * m) time | O(n * m) space
    public static int levenshteinDistance(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return 0;
        }
        if (str1 == null || str1.isEmpty()) return str2.length();
        if (str2 == null || str2.isEmpty()) return str1.length();

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
                    distance[i][j] = 1 + Math.min(
                            Math.min(distance[i - 1][j], distance[i - 1][j - 1]),
                            distance[i][j - 1]
                    );
                }
            }
        }
        return distance[str1.length()][str2.length()];
    }

    // O(n * m) time | O(min(n, m)) space
    public static int levenshteinDistance1(String str1, String str2) {
        if ((str1 == null || str1.isEmpty()) && (str2 == null || str2.isEmpty())) {
            return 0;
        }
        if (str1 == null || str1.isEmpty()) return str2.length();
        if (str2 == null || str2.isEmpty()) return str1.length();

        String small = (str1.length() > str2.length()) ? str2 : str1;
        String big = (str1.length() > str2.length()) ? str1 : str2;

        int[] even = new int[small.length() + 1];
        for (int i = 0; i < even.length; i++) {
            even[i] = i;
        }
        int[] odd = new int[small.length() + 1];

        int[] current;
        int[] prev;

        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 0) {
                current = even;
                prev = odd;
            } else {
                current = odd;
                prev = even;
            }
            current[0] = i;
            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = 1 + Math.min(Math.min(current[j - 1], prev[j - 1]), prev[j]);
                }
            }
        }

        return (big.length() % 2 == 0) ? even[even.length - 1] : odd[odd.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd") == 2);
        System.out.println(levenshteinDistance1("abc", "yabd") == 2);
    }
}
