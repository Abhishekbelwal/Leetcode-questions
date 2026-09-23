class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum - x;
        if (target < 0) return -1; // Not possible if target sum is negative
        
        int left = 0, currentSum = 0, maxLen = -1;
        int n = nums.length;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            // Shrink window from left if current sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // Check if valid window matches target
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : n - maxLen;
    }
}
