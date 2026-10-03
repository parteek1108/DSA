class Solution {
    
    public int reverse(int num){
        int no = 0;
        while(num>0){
            int mod = num%10;
            no = no*10+mod;
            num = num/10;
        }
        return no;
        

    }
    public int countDistinctIntegers(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
            int a =  reverse(arr[i]);
            set.add(a);
        }
        return set.size();
    }
}