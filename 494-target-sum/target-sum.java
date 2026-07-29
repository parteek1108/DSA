class Solution {
    public int solve(int[] arr, int target, int index) {
        if (index == 0) {

            if (target == 0 && arr[0] == 0)
                return 2;

            if (target == arr[0] || target == -arr[0])
                return 1;

            return 0;
        }

        int add = solve(arr, target+arr[index], index - 1);
        int sub =  solve(arr, target-arr[index], index - 1);
        return add + sub;
    }

    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        return solve(arr, target, n - 1);
    }
}