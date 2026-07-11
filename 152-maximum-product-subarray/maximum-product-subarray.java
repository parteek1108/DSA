class Solution {
    public int maxProduct(int[] arr) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i<arr.length;i++){
            if(prefix==0){
                prefix =1;
            }
            prefix *= arr[i];
            max = Math.max(max , prefix);
            
        }
        for(int i=arr.length-1;i>=0;i--){
            if(suffix==0){
                suffix =1;
            }
            suffix *= arr[i];
            max=Math.max(max,suffix);

        }
        return max;
    }
}