package graph;

import java.util.*;

public class WordLadder {

    // O(n * m ^ 2) time | O(n * m ^ 2) space - where m - length of each word, n - total number of words
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> allCombinations = createWordListMap(wordList);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            String currWord = p.word;
            int level = p.level;

            for (int i = 0; i < currWord.length(); i++) {
                String intermediateWord = getKey(currWord, i);

                for (String word : allCombinations.getOrDefault(intermediateWord, new ArrayList<>())) {
                    if (endWord.equals(word)) {
                        return level + 1;
                    }

                    if (!visited.contains(word)) {
                        visited.add(word);
                        queue.add(new Pair(word, level + 1));
                    }
                }
            }
        }


        return 0;
    }

    static class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    private static Map<String, List<String>> createWordListMap(List<String> wordList) {
        Map<String, List<String>> allCombinations = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = getKey(word, i);

                if (allCombinations.containsKey(key)) {
                    allCombinations.get(key).add(word);
                } else {
                    List<String> lst = new ArrayList<>();
                    lst.add(word);
                    allCombinations.put(key, lst);
                }
            }
        }

        return allCombinations;
    }

    private static String getKey(String word, int i) {
        return word.substring(0, i) + "*" + word.substring(i + 1);
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
