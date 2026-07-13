class Solution {
    public void solve(int[] arr, int target ,List<List<Integer>> ans,List<Integer> output , int index ){

        if(target==0){
            ans.add(new ArrayList<>(output));
            return ;
        }

        
        if(index>=arr.length || target <0){
            return ;
        }

        
        

          // include 
        output.add(arr[index]);
        solve(arr , target-arr[index] , ans , output , index+1);

          // backtracking 
        output.remove(output.size()-1); 

        while(index+1<arr.length && arr[index]==arr[index+1]){
            index++;
        }

        // exclude 
        solve(arr , target , ans , output , index+1);

        

    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index =0;
        solve(arr , target , ans , output , index);
        return ans;
    }
}