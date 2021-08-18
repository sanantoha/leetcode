package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress1 {

    public static List<String> validIPAddresses(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i < Math.min(4, str.length()); i++) {
            String[] address = new String[4];
            address[0] = str.substring(0, i);
            if (!isValidSection(address[0])) continue;

            for (int j = i + 1; j < Math.min(i + 4, str.length()); j++) {
                address[1] = str.substring(i, j);
                if (!isValidSection(address[1])) continue;

                for (int k = j + 1; k < Math.min(j + 4, str.length()); k++) {
                    address[2] = str.substring(j, k);
                    address[3] = str.substring(k);
                    if (isValidSection(address[2]) && isValidSection(address[3])) {
                        res.add(String.join(".", address));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValidSection(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i < 0 || i > 255) return false;
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
