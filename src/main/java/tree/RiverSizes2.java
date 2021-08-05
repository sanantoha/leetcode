package tree;

public class RiverSizes2 {

    static int[][] paths = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    public static int riverSizes(int[][] matrix) {
        int totalRivers = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return totalRivers;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    totalRivers++;
                    dfs(matrix, visited, i, j);
                }
            }
        }

        return totalRivers;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int[] path : paths) {
            int futX = x + path[0];
            int futY = y + path[1];

            if (futX >= 0 && futX < matrix.length &&
                    futY >= 0 && futY < matrix[0].length &&
                    !visited[futX][futY] &&
                    matrix[futX][futY] == 1) {
                dfs(matrix, visited, futX, futY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        System.out.println(riverSizes(matrix));
    }
}
