package dynamic;

import java.util.List;

public class WordBreak1 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/347/dynamic-programming/3137/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet","code"))); // true

        System.out.println(wordBreak("applepenapple", List.of("apple","pen"))); // true

        System.out.println(wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))); // false
    }
}
