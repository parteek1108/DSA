import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Arrays.sort(arr);

        int n = arr.length;
        int[] freq = new int[n];
        int idx = 0;

        int count = 1;

        // Store frequencies
        for (int i = 1; i < n; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                freq[idx++] = count;
                count = 1;
            }
        }

        // Last element ki frequency
        freq[idx++] = count;

        // Check duplicate frequencies
        for (int i = 0; i < idx; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (freq[i] == freq[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}