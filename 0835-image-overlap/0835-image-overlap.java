class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        // Collect coordinates of all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }
        
        // Count frequency of each translation vector (offset)
        Map<String, Integer> countMap = new HashMap<>();
        int maxOverlap = 0;
        
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                String offset = (p1[0] - p2[0]) + "," + (p1[1] - p2[1]);
                countMap.put(offset, countMap.getOrDefault(offset, 0) + 1);
                maxOverlap = Math.max(maxOverlap, countMap.get(offset));
            }
        }
        
        return maxOverlap;
    }
}
