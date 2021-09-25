package strings;

public class StringWithoutAAAorBBB {

    public static String stringWithoutAAAorBBB(int a, int b) {
        StringBuilder res = new StringBuilder();

        while (a > 0 && b > 0) {
            if (a > b) {
                res.append("aa").append("b");
                a -= 2;
                b--;
            } else {
                if (a == b && a == 1) {
                    res.append("a").append("b");
                    a -= 1;
                    b -= 1;
                    break;
                } else {
                    res.append("a").append("bb");
                    a--;
                    b -= 2;
                }
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
