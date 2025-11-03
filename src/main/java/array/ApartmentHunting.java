package array;

import java.util.*;

public class ApartmentHunting {

    // O(b * r) time | O(b * r) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, List<String> reqs) {
        if (blocks == null || blocks.isEmpty() || reqs == null || reqs.isEmpty()) {
            return -1;
        }


        List<Map<String, Integer>> distances = createDistances(blocks, reqs);
        for (Map.Entry<String, Boolean> entry : blocks.getFirst().entrySet()) {
            if (entry.getValue()) {
                distances.getFirst().put(entry.getKey(), 0);
            }
        }

        for (int i = 1; i < blocks.size(); i++) {
            for (String req : reqs) {
                if (blocks.get(i).get(req)) {
                    distances.get(i).put(req, 0);
                } else {
                    int oldVal = distances.get(i).get(req);
                    int prevVal = distances.get(i - 1).get(req);
                    int prevValPlusOne = (prevVal != Integer.MAX_VALUE) ? prevVal + 1 : prevVal;
                    distances.get(i).put(req, Math.min(oldVal, prevValPlusOne));
                }
            }
        }

        for (int i = blocks.size() - 2; i >= 0; i--) {
            for (String req : reqs) {
                int oldVal = distances.get(i).get(req);
                int prevVal = distances.get(i + 1).get(req);
                int prevValPlusOne = (prevVal != Integer.MAX_VALUE) ? prevVal + 1 : prevVal;
                distances.get(i).put(req, Math.min(oldVal, prevValPlusOne));
            }
        }

//        System.out.println(distances);

        int resIdx = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < distances.size(); i++) {
            Map<String, Integer> distance = distances.get(i);
            int maxDistancePerBlock = Integer.MIN_VALUE;
            for (String req : reqs) {
                maxDistancePerBlock = Math.max(distance.get(req), maxDistancePerBlock);
            }

            if (minDistance > maxDistancePerBlock) {
                minDistance = maxDistancePerBlock;
                resIdx = i;
            }
        }
        return resIdx;
    }

    private static List<Map<String, Integer>> createDistances(List<Map<String, Boolean>> blocks, List<String> reqs) {
        List<Map<String, Integer>> distances = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Integer> distanceBlock = new HashMap<>();
            for (String req : reqs) {
                distanceBlock.put(req, Integer.MAX_VALUE);
            }
            distances.add(distanceBlock);
        }
        return distances;
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = Arrays.asList(
                new HashMap<String, Boolean>() {{
                    put("gym",    false);
                    put("school", true);
                    put("store",  false);
                }},
                new HashMap<String, Boolean>() {{
                    put("gym",    true);
                    put("school", false);
                    put("store",  false);
                }},
                new HashMap<String, Boolean>() {{
                    put("gym",    true);
                    put("school", true);
                    put("store",  false);
                }},
                new HashMap<String, Boolean>() {{
                    put("gym",    false);
                    put("school", true);
                    put("store",  false);
                }},
                new HashMap<String, Boolean>() {{
                    put("gym",    false);
                    put("school", true);
                    put("store",  true);
                }}
        );
        List<String> reqs = List.of("gym", "school", "store");

        int res = apartmentHunting(blocks, reqs);
        System.out.println(res == 3);
    }
}
