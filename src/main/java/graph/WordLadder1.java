package graph;

import java.util.*;

public class WordLadder1 {

    // O(l ^ 2 * n) time | O(l ^ 2 * n) space
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty() ||
            !wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> allCombinations = createAllCombinations(wordList);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Set<String> seen = new HashSet<>();
        seen.add(beginWord);

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            String currWord = p.word;
            int currLevel = p.level;

            for (int i = 0; i < currWord.length(); i++) {
                String internalWord = getKey(currWord, i);
                for (String word : allCombinations.getOrDefault(internalWord, new ArrayList<>())) {

                    if (endWord.equals(word)) return currLevel + 1;

                    if (!seen.contains(word)) {
                        seen.add(word);
                        queue.add(new Pair(word, currLevel + 1));
                    }
                }
            }
        }

        return 0;
    }

    private static class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    private static Map<String, List<String>> createAllCombinations(List<String> wordList) {
        Map<String, List<String>> allCombinations = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = getKey(word, i);
                List<String> lst = allCombinations.getOrDefault(key, new ArrayList<>());
                lst.add(word);
                allCombinations.put(key, lst);
            }
        }
        return allCombinations;
    }

    private static String getKey(String word, int idx) {
        return word.substring(0, idx) + '*' + word.substring(idx + 1);
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
