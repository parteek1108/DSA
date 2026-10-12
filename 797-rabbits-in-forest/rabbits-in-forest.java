class Solution {
    public int numRabbits(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            int key = arr[i] + 1;

            if (map.containsKey(key)) {
                int freq = map.get(key);
                map.put(key, freq + 1);
            } 
            else {
                map.put(key, 1);
            }
        }
        int res = 0;
        for(int key:map.keySet()){
            int div = map.get(key)/key;
            int rem = map.get(key)%key;
            res += div*key;
            if(rem>0){
                res += key;
            }
        }

        return res;
    }
}