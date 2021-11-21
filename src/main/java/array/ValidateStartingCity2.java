package array;

public class ValidateStartingCity2 {

    // O(n ^ 2) time | O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0) return -1;

        for (int city = 0; city < distances.length; city++) {
            int remainDistance = 0;
            for (int j = city; j < city + distances.length; j++) {
                int idx = j % distances.length;
                remainDistance += fuel[idx] * mpg - distances[idx];
                if (remainDistance < 0) break;
            }
            if (remainDistance >= 0) return city;
        }
        return -1;
    }

    // O(n) time | O(1) space
    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        if (distances == null || distances.length == 0 || fuel == null || fuel.length == 0) return -1;

        int remainDistance = 0;
        int minRemainDistance = Integer.MAX_VALUE;
        int cityWithMinRemainDistance = 0;

        for (int city = 1; city < distances.length; city++) {
            remainDistance += fuel[city - 1] * mpg - distances[city - 1];
            if (minRemainDistance > remainDistance) {
                minRemainDistance = remainDistance;
                cityWithMinRemainDistance = city;
            }
        }

        return cityWithMinRemainDistance;
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
