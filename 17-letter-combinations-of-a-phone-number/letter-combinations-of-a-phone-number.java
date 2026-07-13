class Solution {

    String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public void solve(String digits, int index,
                      StringBuilder output,
                      List<String> ans) {

        // Base Case
        if (index == digits.length()) {
            ans.add(output.toString());
            return;
        }

        // Get letters corresponding to current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try every possible letter
        for (int i = 0; i < letters.length(); i++) {

            // Include
            output.append(letters.charAt(i));

            // Recurse for next digit
            solve(digits, index + 1, output, ans);

            // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        solve(digits, 0, new StringBuilder(), ans);

        return ans;
    }
}