class Solution {
    public int solve(int[] arr, int index , int buy,int[][] dp){
        if(index==arr.length){
            return 0;
        }
        int profit = 0 ;
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        if(buy==1){
            profit = Math.max((-arr[index]+solve(arr,index+1,0,dp)),solve(arr,index+1,1,dp));
        }
        else{
            profit = Math.max(arr[index]+solve(arr,index+1,1,dp),solve(arr,index+1,0,dp));
        }
        return dp[index][buy] = profit;
    }
    public int maxProfit(int[] arr) {
        int[][] dp  = new int[arr.length][2];
        for(int i =0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return solve(arr,0,1,dp);
        
    }
}