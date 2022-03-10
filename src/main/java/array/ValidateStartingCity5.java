package array;

/**
 * https://www.algoexpert.io/questions/Valid%20Starting%20City
 */
public class ValidateStartingCity5 {

    // O(n ^ 2) time | O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0 || mpg <= 0) {
            return -1;
        }

        for (int startCity = 0; startCity < distances.length; startCity++) {
            int remainDistance = 0;
            for (int city = startCity; city < distances.length + startCity; city++) {
                int cityIdx = city % distances.length;
                remainDistance += fuel[cityIdx] * mpg - distances[cityIdx];
                if (remainDistance < 0) break;
            }
            if (remainDistance >= 0) return startCity;
        }

        return -1;
    }

    // O(n) time | O(1) space
    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0 || mpg <= 0) {
            return -1;
        }

        int minRemainDistance = Integer.MAX_VALUE;
        int remainDistance = 0;
        int resCity = 0;

        for (int city = 1; city < distances.length; city++) {
            remainDistance += fuel[city - 1] * mpg - distances[city - 1];
            if (minRemainDistance > remainDistance) {
                minRemainDistance = remainDistance;
                resCity = city;
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
        System.out.println(expected == actual);

        actual = validStartingCity1(distances, fuel, mpg);
        System.out.println(expected == actual);
    }
}
