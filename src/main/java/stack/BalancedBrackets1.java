package stack;

public class BalancedBrackets1 {

    public static boolean balancedBrackets(String str) {
        return false;
    }

    public static void main(String[] args) {
        String input = "([])(){}(())()()";

        System.out.println(balancedBrackets(input));

        System.out.println(balancedBrackets("}{"));
    }
}
