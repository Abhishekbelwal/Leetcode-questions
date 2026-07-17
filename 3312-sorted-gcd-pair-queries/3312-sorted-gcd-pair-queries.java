import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // Find the maximum value in the array to size our frequency maps
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // Step 1: Count frequency of each number in nums
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: For each divisor d, count how many numbers are multiples of d
        long[] gcdPairs = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            long countMultiples = 0;
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                countMultiples += freq[multiple];
            }
            // Number of pairs formed by these multiples
            gcdPairs[d] = (countMultiples * (countMultiples - 1)) / 2;
        }

        // Step 3: Sieve backward to isolate pairs where EXACT GCD is d
        // (Inclusion-Exclusion principle)
        for (int d = maxVal; d >= 1; d--) {
            for (int multiple = 2 * d; multiple <= maxVal; multiple += d) {
                gcdPairs[d] -= gcdPairs[multiple];
            }
        }

        // Step 4: Build a prefix sum array of total pairs up to GCD index d
        long[] prefixSum = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            prefixSum[d] = prefixSum[d - 1] + gcdPairs[d];
        }

        // Step 5: Answer each query using binary search
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIdx = queries[i] + 1; // 0-indexed to 1-indexed count
            
            // Binary search to find the smallest GCD value that covers targetIdx
            int low = 1, high = maxVal;
            int resultGCD = maxVal;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSum[mid] >= targetIdx) {
                    resultGCD = mid;
                    high = mid - 1; // Try to find a smaller valid GCD
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = resultGCD;
        }

        return ans;
    }
}
