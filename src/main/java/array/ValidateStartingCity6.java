package array;

/**
 * https://www.algoexpert.io/questions/Valid%20Starting%20City
 */
public class ValidateStartingCity6 {

    // O(n ^ 2) time | O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0) return -1;

        for (int city = 0; city < distances.length; city++) {
            int remainingDistance = 0;

            for (int idx = city; idx < (city + distances.length); idx++) {
                int currIdx = idx % distances.length;
                remainingDistance += fuel[currIdx] * mpg - distances[currIdx];
                if (remainingDistance < 0) break;
            }
            if (remainingDistance >= 0) return city;
        }
        return -1;
    }

    // O(n) time | O(1) space
    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0) return -1;

        int remainDistance = 0;
        int minRemainDistance = Integer.MAX_VALUE;
        int city = 0;

        for (int i = 1; i < distances.length; i++) {
            remainDistance += fuel[i - 1] * mpg - distances[i - 1];
            if (remainDistance < minRemainDistance) {
                minRemainDistance = remainDistance;
                city = i;
            }
        }
        return city;
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
