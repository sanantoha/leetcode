package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting1 {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, List<String> reqs) {
        return -1;
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
