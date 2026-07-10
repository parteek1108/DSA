class Solution {
    public void solve(int open , int close , String current ,List<String> ans,int n){
        if(current.length()==2*n){
            ans.add(current);
            return ;
        }
        if(open<n){
            solve(open+1,close,current +"(",ans,n);
        }
        if(close<open){
            solve(open,close+1,current +")",ans,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open =0;
        int close =0;
        String current = "";
        solve(open,close,current,ans,n);
        return ans;
    }
}