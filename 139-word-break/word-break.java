class Solution {

    public boolean solve(String s, HashSet<String> set,
                         HashMap<String, Boolean> dp) {

        if (s.length() == 0) {
            return true;
        }

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        for (int i = 0; i < s.length(); i++) {

            String part = s.substring(0, i + 1);

            if (set.contains(part)) {

                if (solve(s.substring(i + 1), set, dp)) {
                    dp.put(s, true);
                    return true;
                }
            }
        }

        dp.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> dp = new HashMap<>();

        return solve(s, set, dp);
    }
}