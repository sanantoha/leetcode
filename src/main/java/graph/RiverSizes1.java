package graph;

public class RiverSizes1 {

    public static int riverSizes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int numIslands = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    numIslands++;
                    dfs(matrix, visited, i, j);
                }
            }
        }

        return numIslands;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int currX, int currY) {
        visited[currX][currY] = true;
        int[][] paths = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < paths.length; i++) {
            int futX = currX + paths[i][0];
            int futY = currY + paths[i][1];

            if (futX >= 0 && futX < matrix.length &&
                futY >= 0 && futY < matrix[0].length &&
                matrix[futX][futY] == 1 && !visited[futX][futY]) {
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
