package test;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TableNonEquiJoin {
    public static void main(String[] args) {
        TreeSet<Integer> t1 = new TreeSet<>(); // n
        t1.add(1);
        t1.add(3);
        t1.add(5); // n * log(n)

        TreeSet<Integer> t2 = new TreeSet<>(); // m
        t2.add(2);
        t2.add(4);
        t2.add(6);
        t2.add(8); // m * log(m)

        Iterator<Integer> iter = t1.iterator();
        while (iter.hasNext()) { // n
            int k1 = iter.next();
            System.out.println(k1 + " " + t2.tailSet(k1)); // m * log(m)
        }
    }
}
