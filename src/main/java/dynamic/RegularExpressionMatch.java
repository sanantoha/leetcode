package dynamic;

/**
 * https://leetcode.com/explore/interview/card/apple/347/dynamic-programming/3135/
 */
public class RegularExpressionMatch {

    public static boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));

        System.out.println(!isMatch("aa", "a*"));

        System.out.println(!isMatch("abcde", ".*"));

        System.out.println(!isMatch("abcde", ".*de"));
    }
}
