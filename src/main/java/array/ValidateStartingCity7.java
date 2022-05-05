package array;

/**
 * https://www.algoexpert.io/questions/Valid%20Starting%20City
 */
public class ValidateStartingCity7 {

    // O(n ^ 2) time | O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0 ||
            fuel.length != distances.length) return 0;

        for (int i = 0; i < distances.length; i++) {
            int remainDistance = 0;

            for (int j = i; j < i + distances.length; j++) {
                int idx = j % distances.length;
                remainDistance += fuel[idx] * mpg - distances[idx];
                if (remainDistance < 0) break;
            }
            if (remainDistance >= 0) return i;
        }
        return -1;
    }

    // O(n) time | O(1) space
    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {

        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0 ||
                fuel.length != distances.length) return 0;

        int minRemainDistance = Integer.MAX_VALUE;

        int remainDistance = 0;
        int resCity = 0;

        for (int i = 1; i < distances.length; i++) {
            remainDistance += fuel[i - 1] * mpg - distances[i - 1];

            if (minRemainDistance > remainDistance) {
                minRemainDistance = remainDistance;
                resCity = i;
            }
        }

        return resCity;
    }

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = validStartingCity(distances, fuel, mpg);
        System.out.println(actual);
        System.out.println(expected == actual);

        actual = validStartingCity1(distances, fuel, mpg);
        System.out.println(expected == actual);
    }
}
