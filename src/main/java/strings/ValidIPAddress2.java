package strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress2 {

    public static List<String> validIPAddresses(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i < Math.min(str.length(), 4); i++) {
            String[] sections = new String[4];
            sections[0] = str.substring(0, i);
            if (!isValidSection(sections[0])) continue;

            for (int j = i + 1; j < Math.min(str.length(), i + 4); j++) {
                sections[1] = str.substring(i, j);
                if (!isValidSection(sections[1])) continue;

                for (int k = j + 1; k < Math.min(str.length(), j + 4); k++) {
                    sections[2] = str.substring(j, k);
                    sections[3] = str.substring(k);
                    if (isValidSection(sections[2]) && isValidSection(sections[3])) {
                        res.add(String.join(".", sections));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValidSection(String str) {
        try {
            int n = Integer.parseInt(str);
            if (n < 0 || n > 255) return false;
            return String.valueOf(n).equals(str);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "1921680";
        System.out.println(validIPAddresses(str));
    }
}
