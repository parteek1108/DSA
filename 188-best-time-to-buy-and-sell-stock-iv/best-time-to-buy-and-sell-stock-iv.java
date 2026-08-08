class Solution {
    public int solve(int k, int[] arr,int index , int buy){
        if(index==arr.length || k==0){
            return 0;
        }
        int profit = 0 ;
        if(buy==1){
            profit = Math.max(-arr[index] + solve(k,arr,index+1,0),solve(k,arr,index+1,1));
        }
        else{
            profit = Math.max(arr[index] + solve(k-1,arr,index+1,1),solve(k,arr,index+1,0));
        }
        return profit;
    }
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        //return solve(k,arr,0,1);
        //int[][][] dp = new int[n+1][2][k+1];
        int[][] ahead = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        // dp[n][0][0] = 0;
        // dp[n][1][0] = 0;
        for(int index = n-1;index>=0;index--){
            for(int buy=0 ; buy<=1;buy++){
                for(int cap = 1;cap<=k;cap++){
                    if(buy==1){
                        curr[buy][cap] = Math.max(-arr[index]+ahead[0][cap],ahead[1][cap]);
                    }
                    else{
                        curr[buy][cap] = Math.max(arr[index]+ahead[1][cap-1],ahead[0][cap]);
                    }
                }
            }
            ahead = curr;
            curr = new int[2][k + 1];
        }
        return ahead[1][k];
    }
}