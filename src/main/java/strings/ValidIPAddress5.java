package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress5 {

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() < 4) return res;

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String[] address = new String[4];
            address[0] = str.substring(0, i);

            if (!isValidAddress(address[0])) continue;

            for (int j = i + 1; j < Math.min(str.length(), i + 4); j++) {
                address[1] = str.substring(i, j);

                if (!isValidAddress(address[1])) continue;

                for (int k = j + 1; k < Math.min(str.length(), j + 4); k++) {
                    address[2] = str.substring(j, k);
                    address[3] = str.substring(k);

                    if (isValidAddress(address[2]) && isValidAddress(address[3])) {
                        res.add(String.join(".", address));
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValidAddress(String str) {
        try {
            int y = Integer.parseInt(str);
            if (y < 0 || y > 255) return false;
            return str.equals(String.valueOf(y));
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static void main(String[] args) {
        String str = "1921680";
        System.out.println(validIPAddresses(str));
    }
}
