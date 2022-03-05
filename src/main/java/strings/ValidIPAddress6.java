package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidIPAddress6 {

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        if (str == null || str.length() < 4) return Collections.emptyList();

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
            return data.equals(String.valueOf(i));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "1921680";
        System.out.println(validIPAddresses(str));
    }
}
