class Solution {
    public int solve(int amount, int[] arr, int index,int[][] dp) {
        if (index == 0) {
            if (amount%arr[0] == 0) {
                return 1;
            }
            else{
                return 0;
            }
            
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int take = 0;
        if (arr[index] <= amount) {
            take = solve(amount - arr[index], arr, index,dp);

        }
        int nottake = solve(amount, arr, index-1,dp);
        return dp[index][amount]= take + nottake;
    }

    public int change(int amount, int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][amount+1];
        // for(int i =0;i<arr.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(amount, arr, n - 1,dp);
        for(int i =0;i<=amount;i++){
            if(i%arr[0] == 0){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
            }
            
        }
        for(int i =1;i<n;i++){
                for(int a =0;a<=amount;a++){
                    int take = 0;
                    if(a>=arr[i]){
                        take = dp[i][a-arr[i]];
                    }
                    int nottake = dp[i-1][a];
                     dp[i][a] = take + nottake ;
                    
                }

            }
            return dp[n-1][amount];
    }
}