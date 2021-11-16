package array;

public class ValidateStartingCity1 {

    // O(n ^ 2) time | O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

        for (int i = 0; i < distances.length; i++) {
            int remainDistance = 0;
            for (int j = i; j < i + distances.length; j++) {
                int city = j % distances.length;
                remainDistance += fuel[city] * mpg - distances[city];
                if (remainDistance < 0) break;
            }
            if (remainDistance >= 0) return i;
        }
        return -1;
    }

    // O(n) time | O(1) space
    public static int validStartingCity1(int[] distances, int[] fuel, int mpg) {
        int remainDistance = 0;
        int minRemainDistance = 0;
        int minIdx = 0;

        for (int i = 1; i < distances.length; i++) {
            remainDistance += fuel[i - 1] * mpg - distances[i - 1];
            if (remainDistance < minRemainDistance) {
                minRemainDistance = remainDistance;
                minIdx = i;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = validStartingCity(distances, fuel, mpg);
        System.out.println(actual);
        System.out.println(expected == actual);

        var actual1 = validStartingCity1(distances, fuel, mpg);
        System.out.println(actual1);
        System.out.println(expected == actual1);
    }
}
