class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int size = row * col;
        int idx = 0;

        k = k % size;

        int[] temp = new int[size];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[idx++] = grid[i][j];
            }
        }

        reverse(temp, 0, size - 1);
        reverse(temp, 0, k - 1);
        reverse(temp, k, size - 1);

        idx = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = temp[idx++];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < col; j++) {
                list.add(grid[i][j]);
            }

            ans.add(list);
        }

        return ans;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}