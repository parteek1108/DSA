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
        int[][] dp = new int[n + 1][2];

        //     for(int i =0;i<arr.length;i++){
        //         Arrays.fill(dp[i],-1);
        //     }
        //    return solve(arr,0,1,dp);
        dp[n][0] = 0;
        dp[n][1] = 0;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                   dp[i][buy]  = Math.max(-arr[i]+dp[i+1][0] , dp[i+1][1]);
                } 
                else {
                   dp[i][buy]  = Math.max(+arr[i]+dp[i+1][1] , dp[i+1][0]);
                }

            }
        }
        return dp[0][1];

    }
}