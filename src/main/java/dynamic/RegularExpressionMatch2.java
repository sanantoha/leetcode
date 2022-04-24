package dynamic;

public class RegularExpressionMatch2 {

    public static boolean isMatch(String s, String p) {
        return false;
    }

    public static boolean isMatchIter(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("abcde", ".*"));
        System.out.println(isMatch("abcde", ".*de"));
        System.out.println(!isMatch("abcde", ".*dk"));

        System.out.println("======================================");

        System.out.println(!isMatchIter("aa", "a"));
        System.out.println(isMatchIter("aa", "a*"));
        System.out.println(isMatchIter("abcde", ".*"));
        System.out.println(isMatchIter("abcde", ".*de"));
        System.out.println(!isMatchIter("abcde", ".*dk"));
    }
}
