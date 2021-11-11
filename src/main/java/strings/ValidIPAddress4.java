package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress4 {

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.isEmpty()) return res;

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String[] addresses = new String[4];
            addresses[0] = str.substring(0, i);

            if (!isValidAddress(addresses[0])) continue;

            for (int j = i + 1; j < Math.min(str.length(), i + 4); j++) {
                addresses[1] = str.substring(i, j);

                if (!isValidAddress(addresses[1])) continue;

                for (int k = j + 1; k < Math.min(str.length(), j + 4); k++) {
                    addresses[2] = str.substring(j, k);
                    addresses[3] = str.substring(k);

                    if (isValidAddress(addresses[2]) && isValidAddress(addresses[3])) {
                        res.add(String.join(".", addresses));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValidAddress(String data) {
        try {
            int i = Integer.parseInt(data);
            if (i < 0 || i > 255) return false;
            return String.valueOf(i).equals(data);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "1921680";
        System.out.println(validIPAddresses(str));
    }
}
