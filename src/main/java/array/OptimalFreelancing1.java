package array;

import java.util.Map;


/**
 * https://www.algoexpert.io/questions/optimal-freelancing
 */
public class OptimalFreelancing1 {

    public static int optimalFreelancing(Map<String, Integer>[] jobs) {
        return -1;
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
