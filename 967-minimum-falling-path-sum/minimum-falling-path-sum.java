class Solution {
    // public int solve(int i, int j, int[][] arr , Integer[][] dp) {
    //     if(i==arr.length-1) return dp[i][j] = arr[i][j];
    //     int rdig = Integer.MAX_VALUE;
    //     int ldig = Integer.MAX_VALUE;
    //     if(dp[i][j]!= null){
    //         return dp[i][j];
    //     }
    //     int down = solve(i+1,j,arr,dp);

    //     if(j<arr[0].length-1){
    //         rdig = solve(i+1,j+1,arr,dp);
    //     }
    //     if(j>0){
    //         ldig = solve(i+1,j-1,arr,dp);
    //     }
    //     return dp[i][j] = arr[i][j]+Math.min(Math.min(ldig,rdig),down);
    // }
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        Integer dp[][] = new Integer[n][arr[0].length];

        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        // Fill DP table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {

                int down = dp[i + 1][j];

                int leftDiag = Integer.MAX_VALUE;
                if (j > 0) {
                    leftDiag = dp[i + 1][j - 1];
                }

                int rightDiag = Integer.MAX_VALUE;
                if (j < m - 1) {
                    rightDiag = dp[i + 1][j + 1];
                }

                dp[i][j] = arr[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;

    }
}