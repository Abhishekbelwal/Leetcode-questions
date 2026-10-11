
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int removed = 0;

        int i = 0;
        int j = (n + 1) / 2;

        while (i < n / 2 && j < n) {
            if (nums.get(i) < nums.get(j)) {
                removed++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return n - 2 * removed;
    }
}
