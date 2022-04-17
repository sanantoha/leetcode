package dynamic;

public class RegularExpressionMatch2 {

    public static boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(!isMatch("aa", "a"));

        System.out.println(isMatch("aa", "a*"));

        System.out.println(isMatch("abcde", ".*"));

        System.out.println(isMatch("abcde", ".*de"));
    }
}
