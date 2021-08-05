package top.interview.question.medium.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

    private List<Integer> lst = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int ind = map.get(val);
        int lastVal = lst.get(lst.size() - 1);

        lst.set(ind, lastVal);

        map.put(lastVal, ind);
        lst.remove(lst.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(3));
        System.out.println(rs.insert(3));
        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());

        System.out.println(rs.insert(1));
        System.out.println(rs.remove(3));

        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());

        System.out.println(rs.insert(0));
        System.out.println(rs.remove(0));
    }
}
