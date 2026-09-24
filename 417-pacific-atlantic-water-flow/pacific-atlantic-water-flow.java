class Solution {

    int row, col;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        row = heights.length;
        col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // Left and Right borders
        for (int i = 0; i < row; i++) {

            dfs(heights, pacific, i, 0, heights[i][0]);

            dfs(heights, atlantic, i, col - 1, heights[i][col - 1]);
        }

        // Top and Bottom borders
        for (int j = 0; j < col; j++) {

            dfs(heights, pacific, 0, j, heights[0][j]);

            dfs(heights, atlantic, row - 1, j, heights[row - 1][j]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(
        int[][] heights,
        boolean[][] visited,
        int rows,
        int cols,
        int prev
    ) {

        // Boundary + visited + height condition
        if (rows < 0 || cols < 0 ||
            rows >= row || cols >= col ||
            visited[rows][cols] ||
            heights[rows][cols] < prev) {

            return;
        }

        visited[rows][cols] = true;

        for (int i = 0; i < 4; i++) {

            int newRow = rows + dx[i];
            int newCol = cols + dy[i];

            dfs(
                heights,
                visited,
                newRow,
                newCol,
                heights[rows][cols]
            );
        }
    }
}