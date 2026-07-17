class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length(); ){
            int startIndex = i ;
            int endIndex = s.lastIndexOf(s.charAt(i));
            for(int j = startIndex ; j<=endIndex;j++){
                int lastindexofnext = s.lastIndexOf(s.charAt(j));
                if(lastindexofnext > endIndex){
                    endIndex = lastindexofnext;

                }

            }
            ans.add(endIndex-startIndex+1);
            i=endIndex+1;
        }
        return ans;
    }
}