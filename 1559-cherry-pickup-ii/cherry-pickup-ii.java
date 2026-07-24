class Solution {

    public int solve(int row, int col1, int col2, int[][] grid, int[][][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        // Out of boundary
        if (col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return Integer.MIN_VALUE;
        }

        // Base Case
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        // Memoization
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int maxi = Integer.MIN_VALUE;

        // 9 possible moves
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int value;

                if (col1 == col2)
                    value = grid[row][col1];
                else
                    value = grid[row][col1] + grid[row][col2];

                value += solve(row + 1, col1 + d1, col2 + d2, grid, dp);

                maxi = Math.max(maxi, value);
            }
        }

        return dp[row][col1][col2] = maxi;
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, m - 1, grid, dp);
    }
}