class Solution {
    public int maxProduct(int[] arr) {
       int mprdt = Integer.MIN_VALUE;
       for(int i =0;i<arr.length;i++){
        int prdt = 1;
        for(int j=i;j<arr.length;j++){
            prdt *= arr[j];
            mprdt = Math.max(prdt,mprdt);
        }
        
       } 
       return mprdt;
    }
}