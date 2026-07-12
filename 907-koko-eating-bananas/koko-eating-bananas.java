class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i]; 
            }
        }
        int low =1 ; 
        int high = max;
        while(low<=high){
            int total =0 ;
            int mid = low + (high-low)/2;
            for(int i=0;i<arr.length;i++){
                total += Math.ceil((double)arr[i]/mid);
            }
            if(total<=h){
                ans = mid;
                high = mid-1;
                
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}