import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {

        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;

        for (int l = 0; l < n - 3; l++) {

            if (l > 0 && arr[l] == arr[l - 1])
                continue;

            for (int i = l + 1; i < n - 2; i++) {

                if (i > l + 1 && arr[i] == arr[i - 1])
                    continue;

                int j = i + 1;
                int k = n - 1;

                while (j < k) {

                    long sum = (long) arr[l] + arr[i] + arr[j] + arr[k];

                    if (sum == target) {

                        List<Integer> output = new ArrayList<>();

                        output.add(arr[l]);
                        output.add(arr[i]);
                        output.add(arr[j]);
                        output.add(arr[k]);

                        list.add(output);

                        j++;
                        k--;
                        

                        while (j < k && arr[j] == arr[j - 1])
                            j++;

                        while (j < k && arr[k] == arr[k + 1])
                            k--;

                    } else if (sum < target) {

                        j++;

                    } else {

                        k--;

                    }
                }
            }
        }

        return list;
    }
}