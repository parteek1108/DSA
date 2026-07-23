class Solution {
    public int solve(int[][] arr , int m , int n,int[][] dp){
        
        if(m<0 || n<0){
            return 0;
        }
        if(arr[m][n]==1){
            return 0;
        }

        if(m==0&&n==0){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up = solve(arr,m-1,n,dp);
        int down = solve(arr,m,n-1,dp);
        return dp[m][n]=up+down;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(arr,m-1,n-1,dp);
    }
}