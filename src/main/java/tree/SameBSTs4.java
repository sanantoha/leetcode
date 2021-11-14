package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs4 {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return false;
    }

    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return false;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(arrayOne, arrayTwo));
        System.out.println(sameBsts1(arrayOne, arrayTwo));
    }
}
