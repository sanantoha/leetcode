package graph;

import java.util.Arrays;

public class ShortestPath {

    private double[] shortest;

    private int[] pred;

    public ShortestPath(double[] shortest, int[] pred) {
        this.shortest = shortest;
        this.pred = pred;
    }

    public double[] getShortest() {
        return shortest;
    }

    public int[] getPred() {
        return pred;
    }

    @Override
    public String toString() {
        return "ShortestPath{" +
                "shortest=" + Arrays.toString(shortest) +
                ", pred=" + Arrays.toString(pred) +
                '}';
    }
}
