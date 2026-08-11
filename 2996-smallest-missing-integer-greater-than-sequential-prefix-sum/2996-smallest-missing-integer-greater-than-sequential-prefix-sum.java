class Solution {
    public int missingInteger(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        while (numSet.contains(sum)) {
            sum++;
        }
        
        return sum;
    }
}
