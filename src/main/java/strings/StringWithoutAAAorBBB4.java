package strings;

public class StringWithoutAAAorBBB4 {

    // O(a + b) time | O(a + b) space
    public static String stringWithoutAAAorBBB(int a, int b) {
        StringBuilder res = new StringBuilder();

        while (a > 0 && b > 0) {
            if (a > b) {
                res.append("aab");
                a -= 2;
                b--;
            } else {
                if (a == b) {
                    res.append("ab");
                    a--;
                    b--;
                    break;
                }
                res.append("abb");
                a--;
                b -=2;
            }
        }

        while (a > 0) {
            res.append("a");
            a--;
        }

        while (b > 0) {
            res.insert(0, "b");
            b--;
        }
        return res.toString();
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
