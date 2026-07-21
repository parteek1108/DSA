class Solution {
    public int solve(int[] arr, int index ,int[] dp) {

        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return arr[0];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans1 = arr[index] + solve(arr, index - 2, dp);
        int ans2 = solve(arr, index - 1, dp);
        return dp[index] = Math.max(ans1, ans2);

    }

    public int rob(int[] arr) {

        // if arraysize ==1
        if (arr.length == 1) {
            return arr[0];
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        int[] dp2 = new int[arr.length];
        Arrays.fill(dp2, -1);

        int[] arr1 = new int[arr.length - 1];
        int[] arr2 = new int[arr.length - 1];

        //last wala exclude h 
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        //first wala exclude h 
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i + 1];
        }

        int ans1 = solve(arr1, arr1.length - 1,dp);
        int ans2 = solve(arr2, arr2.length - 1,dp2);
        return Math.max(ans1, ans2);

    }
}