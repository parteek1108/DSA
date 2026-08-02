class Solution {

    public int longestPalindromeSubseq(String s1) {

        String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            int prevDiagonal = 0;

            for (int j = 1; j <= n; j++) {

                int temp = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + prevDiagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prevDiagonal = temp;
            }
        }

        return dp[n];
    }
}