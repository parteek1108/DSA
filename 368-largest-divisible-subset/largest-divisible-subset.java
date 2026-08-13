class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        int max = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            parent[i] = i;

            for (int j = 0; j < i; j++) {

                if (arr[i] % arr[j] == 0) {

                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        // Backtracking
        ArrayList<Integer> ans = new ArrayList<>();

        while (parent[lastIndex] != lastIndex) {

            ans.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        ans.add(arr[lastIndex]);

        Collections.reverse(ans);

        return ans;
    }
}