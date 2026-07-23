class Solution {
    // public int solve( int i , int j , int[][] arr,int[][] dp ){
    //     if(i==0 && j==0){
    //         return arr[0][0];
    //     }
    //     if(i<0 || j<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up = solve(i-1,j,arr,dp);
    //     int down = solve(i,j-1,arr,dp);
    //     return  dp[i][j] = arr[i][j]+Math.min(up,down);
    // }
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[i][j]=arr[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                if(i>0){
                     up = dp[i-1][j];
                }
                if(j>0) down = dp[i][j-1];
                dp[i][j]=arr[i][j]+Math.min(up,down);
            }
        }
        
        
        return dp[m-1][n-1];
        
    }
}