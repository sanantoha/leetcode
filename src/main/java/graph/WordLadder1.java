package graph;

import java.util.*;

public class WordLadder1 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return -1;
    }

    /**
     * https://leetcode.com/problems/word-ladder/
     * @param args
     */
    public static void main(String[] args) {
        int actual = ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog"));
        System.out.println(actual);
        System.out.println(actual == 5);

        actual = ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log"));
        System.out.println(actual);
        System.out.println(actual == 0);

        actual = ladderLength("MAMA", "SIRI", List.of("SAMA", "SIMA", "SIRA", "SIRI", "MISA", "DISA"));
        System.out.println(actual);
        System.out.println(actual == 5);
    }
}
