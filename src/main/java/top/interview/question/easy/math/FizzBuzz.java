package top.interview.question.easy.math;

import java.util.ArrayList;
import java.util.List;

class Solution0 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}

public class FizzBuzz {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        System.out.println(s.fizzBuzz(3));
        System.out.println(s.fizzBuzz(5));
        System.out.println(s.fizzBuzz(15));
    }
}
