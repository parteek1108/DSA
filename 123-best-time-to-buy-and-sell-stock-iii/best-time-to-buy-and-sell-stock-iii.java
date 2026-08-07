class Solution {
    public int solve(int[] arr, int index, int buy,int cap,int[][][] dp) {
        if (index == arr.length || cap ==2) {
            return 0;
        }
        int profit = 0;
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        if (buy == 1 && cap<=2) {
            profit = Math.max((-arr[index] + solve(arr, index + 1, 0,cap,dp)), solve(arr, index + 1, 1, cap,dp));
        } else {
            profit = Math.max(arr[index] + solve(arr, index + 1, 1, cap+1,dp), solve(arr, index + 1, 0, cap,dp));
        }
        return dp[index][buy][cap] =  profit;
    }
    public int maxProfit(int[] arr) {
        int[][][] dp = new int[arr.length][2][3];
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<2;j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return solve(arr,0,1,0,dp);
    }
}