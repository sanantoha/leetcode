package strings;

public class StringWithoutAAAorBBB5 {

    // O(a + b) time | O(a + b) space
    public static String stringWithoutAAAorBBB(int a, int b) {
        if (a < 0 || b < 0) return "";

        StringBuilder builder = new StringBuilder();

        while (a > 0 && b > 0) {
            if (a > b) {
                builder.append("aab");
                a -= 2;
                b--;
            } else {
                if (a == 1 && b == 1) {
                    builder.append("ab");
                    a--;
                    b--;
                    break;
                }
                builder.append("abb");
                a--;
                b -= 2;
            }
        }

        while (a > 0) {
            builder.append("a");
            a--;
        }

        while (b > 0) {
            builder.insert(0, "b");
            b--;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringWithoutAAAorBBB(1, 1));
        System.out.println(stringWithoutAAAorBBB(3, 3));
        System.out.println(stringWithoutAAAorBBB(2, 5));

        System.out.println(stringWithoutAAAorBBB(5, 3));

        System.out.println(stringWithoutAAAorBBB(3, 3));

        System.out.println(stringWithoutAAAorBBB(1, 4));
    }
}
