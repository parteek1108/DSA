class Solution {
    public int maxOperations(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int rem = k - nums[i];

            if (map.containsKey(rem) && map.get(rem) > 0) {
                count++;

                map.put(rem, map.get(rem) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return count;
    }
}