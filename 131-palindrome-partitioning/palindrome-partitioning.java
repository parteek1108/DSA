class Solution {
    public boolean ispalindrom(String part){
        boolean hkya = true;
        int i =0; int j = part.length()-1;
        while(i<=j){
            if(part.charAt(i)!=part.charAt(j)){
               hkya =false;
            }
            i++;j--;
        }
        return hkya;
    }
    public void solve( String s, List<List<String>> ans , List<String> output){
        if(s.length()==0){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i =0 ;i<s.length();i++){
            String part = s.substring(0,i+1);
            if(ispalindrom(part)){
                output.add(part);
                solve(s.substring(i+1,s.length()),ans ,output);
                output.remove(output.size()-1);
            }
            
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        solve(s,ans,output);
        return ans;

    }
}