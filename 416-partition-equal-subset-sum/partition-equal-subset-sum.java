class Solution {
    public boolean solve(int[] arr, int target, int index, Boolean dp[][]) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (index == 0) {
            if (arr[index] == target) {
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        boolean take = false;
        if (target >= arr[index]) {
            take = solve(arr, target - arr[index], index - 1,dp);
        }
        boolean donttake = solve(arr, target, index - 1,dp);

        return dp[index][target] = take || donttake;
    }

    public boolean canPartition(int[] arr) {
        int n = arr.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum%2 != 0) {
            return false;
        }
        int target = sum/2;
        Boolean dp[][] = new Boolean[n][target+1];
        return solve(arr, target, n - 1,dp);
    }
}