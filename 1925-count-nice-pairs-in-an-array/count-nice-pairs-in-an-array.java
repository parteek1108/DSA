class Solution {
    public int countNicePairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int mod = 1000000007;

        for (int num : nums) {

            int rev = reverse(num);
            int diff = num - rev;

            if (map.containsKey(diff)) {
                ans += map.get(diff);
            }

            map.put(diff, map.getOrDefault(diff, 0) + 1);

            ans %= mod;
        }

        return (int) ans;
    }

    public int reverse(int num) {

        int rev = 0;

        while (num > 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        return rev;
    }
}