class Solution {
    public int maxProfit(int[] arr) {

        int n = arr.length;

        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 0; cap < 2; cap++) {

                    if (buy == 1) {

                        int take = -arr[index] + ahead[0][cap];
                        int notTake = ahead[1][cap];

                        curr[buy][cap] = Math.max(take, notTake);

                    } else {

                        int sell = arr[index] + ahead[1][cap + 1];
                        int notSell = ahead[0][cap];

                        curr[buy][cap] = Math.max(sell, notSell);
                    }
                }
            }

            ahead = curr;
            curr = new int[2][3];
        }

        return ahead[1][0];
    }
}