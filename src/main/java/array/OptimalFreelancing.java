package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class OptimalFreelancing {

    // O(n * log(n)) time | O(1) space
    public static int optimalFreelancing(Map<String, Integer>[] jobs) {
        if (jobs == null || jobs.length == 0) return 0;

        Comparator<Map<String, Integer>> comparator = Comparator.comparing(x -> x.get("payment"));
        Comparator<Map<String, Integer>> reversedComparator = comparator.reversed();
        Arrays.sort(jobs, reversedComparator);

        int lengthOfWeek = 7;

        boolean[] timeline = new boolean[lengthOfWeek];

        int profit = 0;

        for (Map<String, Integer> job : jobs) {
            int maxTime = Math.min(job.get("deadline"), lengthOfWeek);

            for (int time = maxTime - 1; time >= 0; time--) {
                if (!timeline[time]) {
                    timeline[time] = true;
                    profit += job.get("payment");
                    break;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Map<String, Integer>[] jobs = new Map[] {
            Map.of("deadline", 2, "payment", 2),
            Map.of("deadline", 4, "payment", 3),
            Map.of("deadline", 5, "payment", 1),
            Map.of("deadline", 7, "payment", 2),
            Map.of("deadline", 3, "payment", 1),
            Map.of("deadline", 3, "payment", 2),
            Map.of("deadline", 1, "payment", 3)
        };

        int actual = optimalFreelancing(jobs);
        System.out.println(actual);
        System.out.println(actual == 13);
    }

}
