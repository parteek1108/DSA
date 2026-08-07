class Solution {
    public int solve(int[] arr, int index, int buy, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }
        int profit = 0;
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        if (buy == 1) {
            profit = Math.max((-arr[index] + solve(arr, index + 1, 0, dp)), solve(arr, index + 1, 1, dp));
        } else {
            profit = Math.max(arr[index] + solve(arr, index + 1, 1, dp), solve(arr, index + 1, 0, dp));
        }
        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] arr) {
        int n = arr.length;
        //int[][] dp = new int[n + 1][2];

        //     for(int i =0;i<arr.length;i++){
        //         Arrays.fill(dp[i],-1);
        //     }
        //    return solve(arr,0,1,dp);
        int[] next = new int[n+1];
        int[] curr = new int[2];
        // dp[n][0] = 0;
        // dp[n][1] = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                   curr[buy]  = Math.max(-arr[i]+next[0] , next[1]);
                } 
                else {
                   curr[buy]  = Math.max(+arr[i]+next[1] , next[0]);
                }
            }
            next = curr.clone();

        }
        return curr[1];

    }
}