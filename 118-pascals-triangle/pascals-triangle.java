class Solution {
    public List<List<Integer>> generate(int row) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0 ; i<row ; i++){
            List<Integer> output = new ArrayList<>();

            for(int j = 0 ; j<=i ; j++){
               if(j==0 || j==i) output.add(1);
               else{
                List<Integer> prev = result.get(i-1);
                output.add(prev.get(j)+prev.get(j-1));
               } 
            }
            result.add(output);
        }
        return result;
    }
}