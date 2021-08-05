package top.interview.question.easy.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution3 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(Collections.singletonList(1));
        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> lst = result.get(i - 1);

            List<Integer> newLst = new ArrayList<>();
            newLst.add(1);
            for (int j = 1; j < lst.size(); j++) {
                newLst.add(lst.get(j - 1) + lst.get(j));
            }
            newLst.add(1);
            result.add(newLst);
        }

        return result;
    }
}

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.generate(5));
    }
}
