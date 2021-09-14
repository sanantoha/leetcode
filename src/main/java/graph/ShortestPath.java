package graph;

import java.util.Arrays;

public class ShortestPath {

    private double[] shortest;

    private int[] prev;

    public ShortestPath(double[] shortest, int[] prev) {
        this.shortest = shortest;
        this.prev = prev;
    }

    public double[] getShortest() {
        return shortest;
    }

    public int[] getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return "ShortestPath{" +
                "shortest=" + Arrays.toString(shortest) +
                ", prev=" + Arrays.toString(prev) +
                '}';
    }
}
