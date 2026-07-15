import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map stores: [Prefix Sum : Number of times it appeared]
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: an empty prefix sum equals 0
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists, a valid subarray ends here
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // Record the current prefix sum occurrence
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
