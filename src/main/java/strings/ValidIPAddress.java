package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {

    // O(1) time | O(1) space - because length of valid string is short not more than 12 (ip pattern: xxx.xxx.xxx.xxx)
    public static List<String> validIPAddresses(String string) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i < Math.min(4, string.length()); i++) {
            String[] address = new String[4];
            address[0] = string.substring(0, i);
            if (!isValidSection(address[0])) continue;

            for (int j = i; j < Math.min(i + 4, string.length()); j++) {
                address[1] = string.substring(i, j);
                if (!isValidSection(address[1])) continue;

                for (int k = j; k < Math.min(j + 4, string.length()); k++) {
                    address[2] = string.substring(j, k);
                    address[3] = string.substring(k);

                    if (isValidSection(address[2]) && isValidSection(address[3])) {
                        result.add(String.join(".", address));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValidSection(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i > 255) return false;
            return str.equals(String.valueOf(i));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "1921680";

        System.out.println(validIPAddresses(str));
    }
}
