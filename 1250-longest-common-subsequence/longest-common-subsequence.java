class Solution {
    public int solve(String s1, String s2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = 1 + solve(s1, s2, index1 - 1, index2 - 1, dp);
        }
        return dp[index1][index2] = Math.max(solve(s1, s2, index1 - 1, index2, dp),
                solve(s1, s2, index1, index2 - 1, dp));
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int i =0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(s1 ,s2,n-1,m-1,dp);
        for(int i =0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] =  1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
        }
        return dp[n][m];
    }
}