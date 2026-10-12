class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int boat =0;
       int i =0;
       int j = arr.length-1;
       while(i<=j){
            if(arr[i]+arr[j]<=limit){
                boat++;
                i++;j--;
            }
            else{
                j--;
                boat++;
            }
       }
        return boat;
    }
}