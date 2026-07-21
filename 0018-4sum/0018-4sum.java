import java.util.*;

class Solution {
    // Function to find all unique quadruplets
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Sort array
        Arrays.sort(arr);

        // Step 2: First loop for first number
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Step 3: Second loop for second number
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                // Step 4: Two pointers
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] +
                               arr[left] + arr[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j],
                                              arr[left], arr[right]));

                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }
}