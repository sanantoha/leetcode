package array;

/**
 * https://www.algoexpert.io/questions/Valid%20Starting%20City
 */
public class ValidateStartingCity1 {

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        return -1;
    }

    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        return -1;
    }

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = validStartingCity(distances, fuel, mpg);
        System.out.println(expected == actual);

        actual = validStartingCity1(distances, fuel, mpg);
        System.out.println(expected == actual);
    }
}
