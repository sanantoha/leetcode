package top.interview.question.easy.strings;

import java.util.Arrays;

class Solution0 {

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - i - 1);
        }
    }
}

public class ReverseString {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        char[] arr = {'h','e','l','l','o'};

        s.reverseString(arr);

        System.out.println(Arrays.toString(arr));


        char[] arr1 = {'H','a','n','n','a','h'};

        s.reverseString(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}
