package test;

import java.util.*;
import java.util.stream.Collectors;

public class TableNonEquiJoin {
    public static void main(String[] args) {
        TreeSet<Integer> t1 = new TreeSet<>(); // n
        t1.add(1);
        t1.add(3);
        t1.add(5); // n * log(n) // no need to create first tree
        t1.add(15);

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


        List<double[]> lst = new ArrayList<>();
        lst.add(new double[] {1, 1});
        lst.add(new double[] {1, 2});
        lst.add(new double[] {2, Double.NaN});
        lst.add(new double[] {2, 3});
        lst.add(new double[] {3, 3});
        lst.add(new double[] {3, 4});

        var res = lst.stream()
                .collect(Collectors.groupingBy(arr -> arr[0], Collectors.summarizingDouble(arr -> arr[1])))
                .entrySet().stream().map(entry -> new double[] {entry.getKey(), entry.getValue().getSum()})
                .collect(Collectors.toList());

        res.forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("=========");


        Comparator<double[]> comparator = (arr1, arr2) -> {
            if (Double.isNaN(arr1[1])) return -1;
            if (Double.isNaN(arr2[1])) return 1;
            if (arr1[1] == arr2[1]) {
                return Double.compare(arr1[0], arr2[0]);
            }
            return Double.compare(arr1[1], arr2[1]);
        };

        Collections.sort(res, comparator);

        res.forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
