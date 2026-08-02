class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        //int dp[][] = new int[n+1][n+1];
        int[] curr = new int[n+1];
        int[] prev = new int[n+1];
        for(int i =0;i<=n;i++){
            prev[i] = 0;
        }
        for(int i =0;i<=n;i++){
            curr[0] = 0;
        }
        for(int i =1;i<=n;i++){
            curr = new int[n+1];
            for(int j =1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr;
        }
        return curr[n];
    }
}