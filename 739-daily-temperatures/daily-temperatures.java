class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int days[] = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<temp.length;i++){
            while(!st.isEmpty()){
                if(temp[st.peek()]<temp[i]){
                    int index = st.pop();
                    days[index] = i-index;
                }
                else{
                    break;
                }

            }
            st.push(i);
        }
        return days;

    }
}