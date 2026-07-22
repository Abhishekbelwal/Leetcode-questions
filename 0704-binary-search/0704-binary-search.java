class Solution {
    public int search(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == nums[mid]) {
                return mid;
            } else if (key > nums[mid]) {
                start = mid + 1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}