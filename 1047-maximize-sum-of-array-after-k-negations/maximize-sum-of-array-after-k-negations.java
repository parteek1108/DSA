class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int sum =0;
        if(k%2==0 && arr[0]>=0){
            for(int ele :arr){
                sum+= ele;
            }
        }
        else{
            
            while(k>0){
                arr[0] = -arr[0];
                k-- ;
                Arrays.sort(arr); 
            }
            for(int ele :arr){
                 sum+= ele;
            }
        }
        
        return sum;
    }
}