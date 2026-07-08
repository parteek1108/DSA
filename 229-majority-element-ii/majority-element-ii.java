class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int count=0;
        int limit=arr.length/3;
        int i=0 , j=0 ;
        while(j<arr.length){
            int element = arr[i];
            while(j<arr.length && arr[j]==element){
                j++;
                count++;
            }
            if(count>limit){
                ans.add(arr[i]);
                
            }
            i=j;
            count=0;
        }
        return ans;

    }
}