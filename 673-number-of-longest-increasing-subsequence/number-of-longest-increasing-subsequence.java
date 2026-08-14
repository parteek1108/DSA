class Solution {

    class Pair {
        int len;
        int count;

        Pair(int len, int count) {
            this.len = len;
            this.count = count;
        }
    }

    Pair[][] dp;

    Pair solve(int[] nums, int index, int prev) {

        // Base case
        if (index == nums.length) {
            return new Pair(0, 1);
        }

        // prev + 1 because prev can be -1
        if (dp[index][prev + 1] != null) {
            return dp[index][prev + 1];
        }

        // NOT TAKE
        Pair notTake = solve(nums, index + 1, prev);

        // TAKE
        Pair take = new Pair(0, 0);

        if (prev == -1 || nums[index] > nums[prev]) {
            Pair next = solve(nums, index + 1, index);

            take.len = 1 + next.len;
            take.count = next.count;
        }

        Pair ans;

        // Take gives longer subsequence
        if (take.len > notTake.len) {
            ans = take;
        }

        // Not take gives longer subsequence
        else if (notTake.len > take.len) {
            ans = notTake;
        }

        // Both have same maximum length
        else {
            ans = new Pair(
                take.len,
                take.count + notTake.count
            );
        }

        return dp[index][prev + 1] = ans;
    }

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        dp = new Pair[n][n + 1];

        return solve(nums, 0, -1).count;
    }
}