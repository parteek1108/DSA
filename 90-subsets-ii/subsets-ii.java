
class Solution {
    public void solve( int[] nums, int index , List<Integer> output,List<List<Integer>> ans){
        if(index>=nums.length){
            ans.add(new ArrayList<>(output));
            return;

        }
        output.add(nums[index]);

        //include
        solve(nums,index+1,output,ans);

        //backtraking step
        output.remove(output.size()-1);

        while(index+1<nums.length &&nums[index]==nums[index+1]){
            index++;
        }

        //exclude
        solve(nums,index+1,output,ans);


    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int index =0 ;
        List<Integer> output = new ArrayList<>();
        solve(nums,index,output,ans);
        return ans;

    }
}