class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        // Search space
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int daysUsed = 1;
            int currentLoad = 0;

            // Check if capacity = mid is possible
            for (int weight : weights) {
                if (currentLoad + weight <= mid) {
                    currentLoad += weight;
                } else {
                    daysUsed++;
                    currentLoad = weight;
                }
            }

            if (daysUsed <= days) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}