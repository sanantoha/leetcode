package strings;

import java.util.List;

public class ValidIPAddress7 {

    public static List<String> validIPAddresses(String str) {
        return null;
    }

    public static void main(String[] args) {
        String str = "1921680";
        // [1.9.216.80, 1.92.16.80, 1.92.168.0, 19.2.16.80, 19.2.168.0, 19.21.6.80, 19.21.68.0, 19.216.8.0, 192.1.6.80, 192.1.68.0, 192.16.8.0]
        System.out.println(validIPAddresses(str));
    }
}
