class Solution {
    public int solve(int[] arr , int index , int prev ,int[][] dp){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][prev+1] != -1){
            return dp[index][prev+1];
        }
        int take =0;
        if(prev==-1 || arr[index]>arr[prev]){
             take = 1+solve(arr,index+1,index,dp);
        }
        int nontake = solve(arr,index+1,prev,dp);
        return dp[index][prev+1] = Math.max(take,nontake);
    }
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i] , -1);
        }
         return solve(arr,0,-1,dp);
    }
}