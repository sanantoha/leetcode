package graph;

import java.util.List;

public class WordLadderII1 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }

    public static void main(String[] args) {
        var wordList = List.of("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";

        // [[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]
        List<List<String>> actual = findLadders(beginWord, endWord, wordList);
        System.out.println(actual);
    }
}
