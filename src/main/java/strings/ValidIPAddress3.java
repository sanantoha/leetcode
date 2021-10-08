package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress3 {

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String[] addresses = new String[4];
            addresses[0] = str.substring(0, i);
            if (!isValid(addresses[0])) continue;

            for (int j = i + 1; j < Math.min(i + 4, str.length()); j++) {
                addresses[1] = str.substring(i, j);
                if (!isValid(addresses[1])) continue;

                for (int k = j + 1; k < Math.min(j + 4, str.length()); k++) {
                    addresses[2] = str.substring(j, k);
                    addresses[3] = str.substring(k);
                    if (isValid(addresses[2]) && isValid(addresses[3])) {
                        res.add(String.join(".", addresses));
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i < 0 || i > 255) return false;
            return str.equals(String.valueOf(i));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "1921680";
        System.out.println(validIPAddresses(str));
    }
}
