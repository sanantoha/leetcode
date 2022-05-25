package graph;

import java.util.*;

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.isEmpty() || endWord == null ||
                endWord.isEmpty() || !wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        List<List<String>> paths = new ArrayList<>();

        Map<String, List<String>> adjList = getAdjList(wordList);

        Queue<Pair> queue = new LinkedList<>();

        List<String> wordSeq = new ArrayList<>();
        wordSeq.add(beginWord);
        queue.add(new Pair(beginWord, wordSeq));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Set<String> currVisited = new HashSet<>();

            while (size-- > 0) {
                Pair pair = queue.remove();
                String word = pair.word;
                List<String> currWordSeq = pair.wordSeq;
                if (endWord.equals(word)) {
                    paths.add(currWordSeq);
                    continue;
                }

                for (int i = 0; i < word.length(); i++) {
                    String key = getKey(word, i);
                    for (String currWord : adjList.getOrDefault(key, new ArrayList<>())) {
                        if (!visited.contains(currWord)) {
                            currVisited.add(currWord);
                            List<String> newWordSeq = new ArrayList<>(currWordSeq);
                            newWordSeq.add(currWord);
                            queue.add(new Pair(currWord, newWordSeq));
                        }
                    }
                }
            }
            visited.addAll(currVisited);
        }

        return paths;
    }


    static class Pair {
        String word;
        List<String> wordSeq;

        public Pair(String word, List<String> wordSequence) {
            this.word = word;
            this.wordSeq = wordSequence;
        }
    }

    private static Map<String, List<String>> getAdjList(List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = getKey(word, i);
                List<String> lst = adjList.getOrDefault(key, new ArrayList<>());
                lst.add(word);
                adjList.put(key, lst);
            }
        }

        return adjList;
    }

    private static String getKey(String word, int i) {
        return word.substring(0, i) + '*' + word.substring(i + 1);
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
