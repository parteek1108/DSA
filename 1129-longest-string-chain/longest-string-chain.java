class Solution {

    public boolean check(String s1, String s2) {
        // s1 should be predecessor of s2
        // length difference must be exactly 1

        if (s2.length() - s1.length() != 1) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s1.length();
    }

    public int longestStrChain(String[] words) {

        int n = words.length;

        // Important: sort by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (check(words[j], words[i])) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}