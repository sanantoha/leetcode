package top.interview.question.easy.math;

import java.util.HashMap;
import java.util.Map;

class Solution3 {

    private final Map<Character, Integer> map = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int v = map.get(c);
            if (prev > v) {
                result -= v;
            } else {
                result += v;
            }
            prev = v;
        }
        return result;
    }
}

public class RomanToInteger {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("XCIX")); // 99
        System.out.println(s.romanToInt("XCVIII"));

    }
}
