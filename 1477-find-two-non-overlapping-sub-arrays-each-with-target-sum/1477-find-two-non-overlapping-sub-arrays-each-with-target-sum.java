import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        
        // best[i] stores the minimum length of a valid subarray in arr[0...i]
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        for (int right = 0; right < n; right++) {
            sum += arr[right]; // Expand the window
            
            // Shrink the window from the left if the sum exceeds the target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            // Found a subarray that matches the target sum
            if (sum == target) {
                int currentLen = right - left + 1;
                
                // Check if there is a non-overlapping valid subarray to the left
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[left - 1] + currentLen);
                }
                
                // Record the minimum length ending at 'right'
                best[right] = currentLen;
            }
            
            // Carry forward the minimum length found so far
            if (right > 0) {
                best[right] = Math.min(best[right], best[right - 1]);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
