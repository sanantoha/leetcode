package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraverse5 {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));

        System.out.println(zigzagTraverse(test));
    }
}
