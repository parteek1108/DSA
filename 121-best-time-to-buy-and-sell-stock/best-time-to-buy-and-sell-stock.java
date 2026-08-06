class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int mini = arr[0];
        int profit = 0;
        for(int i =0;i<n;i++){
            int cost  = arr[i] - mini;
            profit = Math.max(profit,cost);
            mini = Math.min(mini,arr[i]);
        }
        return profit;
    }
}