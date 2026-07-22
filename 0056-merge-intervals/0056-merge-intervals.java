import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skip if this interval is already merged
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}