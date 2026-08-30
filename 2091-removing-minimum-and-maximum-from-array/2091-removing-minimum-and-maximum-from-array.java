class Solution {
    public int minimumDeletions(int[] nums) {

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int n = nums.length;

        // Dono front se
        int case1 = Math.max(minIndex, maxIndex) + 1;

        // Dono back se
        int case2 = n - Math.min(minIndex, maxIndex);

        // Min front se, max back se
        int case3 = (minIndex + 1) + (n - maxIndex);

        // Max front se, min back se
        int case4 = (maxIndex + 1) + (n - minIndex);

        return Math.min(
            Math.min(case1, case2),
            Math.min(case3, case4)
        );
    }
}