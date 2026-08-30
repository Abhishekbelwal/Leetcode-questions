class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) min = i;
            if (nums[i] > nums[max]) max = i;
        }

        int left = Math.min(min, max);
        int right = Math.max(min, max);
        int n = nums.length;

        return Math.min(
            right + 1,
            Math.min(
                n - left,
                left + 1 + n - right
            )
        );
    }
}