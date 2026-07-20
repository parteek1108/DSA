class Solution {
    public int solve(int[] arr, int index, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return arr[0];
        }

        if(dp[index] != -1){
            return dp[index];
        }
        int rob = arr[index]+solve(arr, index - 2,dp);
        int skip = solve(arr, index - 1,dp);
        dp[index]= Math.max(rob, skip);
        return dp[index];
    }

    public int rob(int[] arr) {
        int n = arr.length-1;

        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        int index = arr.length - 1;
        int chori = 0;
        return solve(arr, index, dp);

    }
}