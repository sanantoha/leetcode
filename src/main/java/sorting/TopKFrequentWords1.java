package sorting;

import java.util.List;

public class TopKFrequentWords1 {

    public static List<String> topKFrequent(String[] words, int k) {
        return null;
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
