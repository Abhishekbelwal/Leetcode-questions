import java.util.Arrays;

class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxSoFar = 0;
        
        // 1. Calculate prefix GCD in-place to avoid using O(n) auxiliary space
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            nums[i] = gcd(nums[i], maxSoFar);
        }
        
        // 2. Sort the array in non-decreasing order
        Arrays.sort(nums);
        
        // 3. Form pairs from outside-in using two pointers and sum up their GCDs
        long totalSum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            totalSum += gcd(nums[left], nums[right]);
            left++;
            right--;
        }
        
        return totalSum;
    }
}
