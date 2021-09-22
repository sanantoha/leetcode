package top.interview.question.zalando;

import java.util.HashMap;
import java.util.Map;

public class ABletters {

    public static String solution(int a, int b) {
        StringBuilder res = new StringBuilder();

        while (a > 0 && b > 0) {
            if (a > b) {
                res.append("aa").append("b");
                a -= 2;
                b--;
            } else {
                if (a == b && a == 1) {
                    res.append("a").append("b");
                    a--;
                    b--;
                    break;
                }
                res.append("a").append("bb");
                b -= 2;
                a--;
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
        System.out.println(solution(1, 1));
        System.out.println(solution(3, 3));
        System.out.println(solution(2, 5));

        System.out.println(solution(5, 3));
//
        System.out.println(solution(3, 3));

        System.out.println(solution(1, 4));
    }
}
