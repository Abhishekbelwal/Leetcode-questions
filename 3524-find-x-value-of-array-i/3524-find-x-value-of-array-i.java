class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        
        // dp[r] tracks the number of subarrays ending at the 
        // current position with (product % k) == r
        long[] dp = new long[k];
        
        for (final int num : nums) {
            long[] newDp = new long[k];
            final int numMod = num % k;
            
            // Scenario 1: Start a brand-new subarray using only the current number
            newDp[numMod] = 1;
            
            // Scenario 2: Extend all previously active subarrays to include the current number
            for (int i = 0; i < k; ++i) {
                if (dp[i] > 0) {
                    final int newMod = (int) (1L * i * numMod % k);
                    newDp[newMod] += dp[i];
                }
            }
            
            // Collect the counts from the current position into the final answer array
            for (int i = 0; i < k; ++i) {
                ans[i] += newDp[i];
            }
            
            // Move to the next element
            dp = newDp;
        }
        
        return ans;
    }
}
