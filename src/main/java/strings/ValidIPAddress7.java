package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidIPAddress7 {

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        if (str.length() < 4) return Collections.emptyList();

        List<String> res = new ArrayList<>();

        String[] address = new String[4];

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            address[0] = str.substring(0, i);

            if (!isValid(address[0])) continue;

            for (int j = i + 1; j < Math.min(str.length(), i + 4); j++) {
                address[1] = str.substring(i, j);

                if (!isValid(address[1])) continue;

                for (int k = j + 1; k < Math.min(str.length(), j + 4); k++) {
                    address[2] = str.substring(j, k);
                    address[3] = str.substring(k);

                    if (isValid(address[2]) && isValid(address[3])) {
                        res.add(String.join(".", address));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValid(String data) {
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
        // [1.9.216.80, 1.92.16.80, 1.92.168.0, 19.2.16.80, 19.2.168.0, 19.21.6.80, 19.21.68.0, 19.216.8.0, 192.1.6.80, 192.1.68.0, 192.16.8.0]
        System.out.println(validIPAddresses(str));
    }
}
