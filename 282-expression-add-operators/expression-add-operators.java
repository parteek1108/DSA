class Solution {

    public void solve(String num, int target, int index,String expression, long currentValue,long previousValue, List<String> ans) {

        // Base Case
        if (index == num.length()) {
            if (currentValue == target) {
                ans.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Skip numbers with leading zero
            if (i > index && num.charAt(index) == '0')
                break;

            String part = num.substring(index, i + 1);
            long number = Long.parseLong(part);

            // First number
            if (index == 0) {
                solve(num,target,i + 1, part, number, number,ans);
            }

            // +
            else {

                solve(num, target,i + 1,expression + "+" + part,currentValue + number,number,ans);

                // -
                solve(num,target,i + 1,expression + "-" + part,currentValue - number,-number,ans);

                // *
                solve(num,target,i + 1,expression + "*" + part,currentValue - previousValue + previousValue * number,previousValue * number,ans);
            }
        }
    }

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        solve(num,target,0,"", 0,0,ans);

        return ans;
    }
}