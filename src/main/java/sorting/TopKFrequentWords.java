package sorting;

import java.util.*;

public class TopKFrequentWords {

    // O(n * log(k)) time | O(n) space
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k < 1) {
            return res;
        }

        Map<String, Word> map = new HashMap<>();

        for (String word : words) {
            Word node = map.getOrDefault(word, new Word(word, 0));
            node.cnt++;
            map.put(word, node);
        }

        PriorityQueue<Word> heap = new PriorityQueue<>(k + 1, (o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return String.CASE_INSENSITIVE_ORDER.compare(o2.word, o1.word);
            }
            return Integer.compare(o1.cnt, o2.cnt);
        });

        int i = 0;
        for (Word word : map.values()) {
            heap.add(word);
            if (i >= k) {
                heap.remove();
            }
            i++;
        }

        while (!heap.isEmpty()) {
            res.add(heap.remove().word);
        }
        Collections.reverse(res);
        return res;
    }

    static class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        public int getCnt() {
            return cnt;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/346/sorting-and-searching/3133/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(
                topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2)
        ); // {"i", "love"}

        System.out.println(
                topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4)
        ); // {"the","is","sunny","day"}
    }

}
