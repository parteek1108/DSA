class Solution {
    public void solve(int[] arr, int target ,List<List<Integer>> ans,List<Integer> output , int index ){
        if(index>=arr.length || target <0){
            return ;
        }
        if(target==0){
            ans.add(new ArrayList<>(output));
            return ;
        }

          // include 
        output.add(arr[index]);
        solve(arr , target-arr[index] , ans , output , index);

          // backtracking 
        output.remove(output.size()-1); 

        // exclude 
        solve(arr , target , ans , output , index+1);

        

    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index =0;
        solve(arr , target , ans , output , index);
        return ans;
    }
}