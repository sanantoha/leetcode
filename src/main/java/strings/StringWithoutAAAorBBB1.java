package strings;

public class StringWithoutAAAorBBB1 {

    // O(a + b) time | O(a + b) space
    public static String stringWithoutAAAorBBB(int a, int b) {
        StringBuilder builder = new StringBuilder();

        while (a > 0 && b > 0) {
            if (a > b) {
                builder.append("aa").append("b");
                a -= 2;
                b--;
            } else {
                if (a == 1 && b == 1) {
                    builder.append("a").append("b");
                    a--;
                    b--;
                    break;
                }

                builder.append("a").append("bb");
                a--;
                b -= 2;
            }
        }

        if (a > 0) {
            builder.append("a");
            a--;
        }

        if (b > 0) {
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
//
        System.out.println(stringWithoutAAAorBBB(3, 3));

        System.out.println(stringWithoutAAAorBBB(1, 4));
    }
}
