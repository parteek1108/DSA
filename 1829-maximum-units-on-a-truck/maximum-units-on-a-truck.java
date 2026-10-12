class Solution {
    public int maximumUnits(int[][] arr, int size) {
        int max =0;

        Arrays.sort(arr, (a, b) ->Integer.compare(b[1], a[1]));
        for(int i=0;i<arr.length;i++){
            int nb = arr[i][0];
            int ni = arr[i][1];
            int min = Math.min(nb,size);
            size -= min;
            max += min*ni;
            if(size==0){
                return max ;
            }

        }
        return max;
    }
}