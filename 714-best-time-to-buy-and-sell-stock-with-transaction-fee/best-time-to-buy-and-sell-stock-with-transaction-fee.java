class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[index][buy] = Math.max(-arr[index] + dp[index + 1][0],dp[index + 1][1]);
                }
                 else {
                    dp[index][buy] = Math.max((arr[index] + dp[index + 1][1]-fee),dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}