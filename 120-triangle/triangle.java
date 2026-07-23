class Solution {
    public int solve(int i , int j ,List<List<Integer>> arr,Integer [][] dp ){
        int  n = arr.size();

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(i==n-1){
            return dp[i][j]  = arr.get(i).get(j);
        }
        
        return dp[i][j] =  arr.get(i).get(j) + Math.min(solve(i+1,j,arr,dp),solve(i+1,j+1,arr,dp));
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        Integer [][] dp = new Integer[n][n];
        // for(int i = 0 ; i<arr.size();i++){
        //     Arrays.fill(dp[i],-1);
        // }
        return solve(0,0,arr,dp);
    }
}