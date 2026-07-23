class Solution {
    public int solve( int i , int j , int[][] arr,int[][] dp ){
        if(i==0 && j==0){
            return arr[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = solve(i-1,j,arr,dp);
        int down = solve(i,j-1,arr,dp);
        return  dp[i][j] = arr[i][j]+Math.min(up,down);
    }
    public int minPathSum(int[][] arr) {
        int sum =0;
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(m-1,n-1,arr,dp);
        
    }
}