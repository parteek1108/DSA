class Solution {
    public int solve(int[] arr, int amount, int index,int[][] dp){
        if(index==0){
            if(amount%arr[index]==0){
                return amount/arr[index];
            }
            
            else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int take =Integer.MAX_VALUE;
        if(arr[index]<=amount){
             int res =solve(arr,amount-arr[index],index,dp);
            if(res!=Integer.MAX_VALUE){
                take = res+1;
            }
        }
        int nontake = 0+solve(arr,amount,index-1,dp);
        return dp[index][amount] = Math.min(take,nontake);
    }

    public int coinChange(int[] arr, int amount) {
        int n = arr.length;
        int[][] dp = new int[n][amount+1];
        // for(int i =0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // int ans =  solve(arr, amount, n - 1,dp);
        // if(ans==Integer.MAX_VALUE){
        //     return -1;
        // }
        // return ans;
        for(int i =0;i<=amount;i++){
            if(i%arr[0]==0){
                dp[0][i]= i / arr[0];
            }
            else{
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<n;i++){
            for(int a = 0;a<=amount;a++){
                int take = Integer.MAX_VALUE;
                if(arr[i]<=a){
                    int res = dp[i][a-arr[i]];
                    if(res!=Integer.MAX_VALUE){
                        take = res+1;
                    }
                }
                int nontake = dp[i-1][a];
                dp[i][a] = Math.min(take,nontake);

            }
        }
        if(dp[n-1][amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[n-1][amount];

    }
}