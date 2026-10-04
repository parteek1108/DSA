class Solution {
    public int[] findEvenNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // First digit
        for (int i = 1; i <= 9; i++) {

            if (freq[i] == 0) continue;
            freq[i]--;

            // Second digit
            for (int j = 0; j <= 9; j++) {

                if (freq[j] == 0) continue;
                freq[j]--;

                // Last digit must be even
                for (int k = 0; k <= 8; k += 2) {

                    if (freq[k] > 0) {
                        int num = i * 100 + j * 10 + k;
                        ans.add(num);
                    }
                }

                freq[j]++;
            }

            freq[i]++;
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}