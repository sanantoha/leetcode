package top.interview.question.zalando;

public class ABletters {

    public static String solution(int a, int b) {
        return solution(a, b, "");
    }

    private static String solution(int a, int b, String ans) {
        if (a + b == 0) return ans;

        if (a > b) {
            if (ans.endsWith("b") && a > 1) {
                return solution(a - 2, b, ans + "aa");
            }
            return solution(a - 1, b, ans + "a");
        } else {
            if (ans.endsWith("a") && b > 1) {
                return solution(a, b - 2, ans + "bb");
            }
            return solution(a, b - 1, ans + "b");
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution(5, 3));
//
//        System.out.println(solution(3, 3));

        System.out.println(solution(1, 4));
    }
}
