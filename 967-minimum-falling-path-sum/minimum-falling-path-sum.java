class Solution {
    public int solve(int i, int j, int[][] arr , Integer[][] dp) {
        if(i==arr.length-1) return dp[i][j] = arr[i][j];
        

        int rdig = Integer.MAX_VALUE;
        int ldig = Integer.MAX_VALUE;

        if(dp[i][j]!= null){
            return dp[i][j];
        }
        int down = solve(i+1,j,arr,dp);

        if(j<arr[0].length-1){
            rdig = solve(i+1,j+1,arr,dp);
        }
        
        if(j>0){
            ldig = solve(i+1,j-1,arr,dp);
        }
        return dp[i][j] = arr[i][j]+Math.min(Math.min(ldig,rdig),down);
    }
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;

        Integer dp[][] = new Integer[n][arr[0].length];
        
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, solve(0, i, arr,dp));
        }
        return mini;
    }
}