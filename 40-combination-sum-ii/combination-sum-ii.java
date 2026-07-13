class Solution {

    public void solve(int[] arr, int target,
                      List<List<Integer>> ans,
                      List<Integer> output,
                      int index) {

        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index >= arr.length || target < 0) {
            return;
        }

        // Pruning
        if (arr[index] > target) {
            return;
        }

        // Include
        output.add(arr[index]);
        solve(arr, target - arr[index], ans, output, index + 1);

        // Backtrack
        output.remove(output.size() - 1);

        // Skip duplicates
        while (index + 1 < arr.length && arr[index] == arr[index + 1]) {
            index++;
        }

        // Exclude
        solve(arr, target, ans, output, index + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, ans, new ArrayList<>(), 0);

        return ans;
    }
}