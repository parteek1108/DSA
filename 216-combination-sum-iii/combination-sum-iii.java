class Solution {
    public void solve(int k, int n ,List<List<Integer>> ans,List<Integer> output,int start){
        if(n==0 && output.size()==k){
            ans.add(new ArrayList<>(output));
            return;   
        }
        if( n<0 || output.size()>k || start > 9 ){
            return;
        }

        //include 
        output.add(start);
        solve(k,n-start,ans,output,start+1);

        //backtracking
        output.remove(output.size()-1);


        //exclude
        solve(k,n,ans,output,start+1);
        

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int start = 1;
        solve(k,n,ans,output,start);
        return ans;
    }
}