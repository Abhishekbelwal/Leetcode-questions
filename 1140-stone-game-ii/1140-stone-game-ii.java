class Solution {
    private int[] suffixSum;
    private int[][] memo;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        memo = new int[n][n + 1];
        return dp(0, 1);
    }

    private int dp(int i, int m) {
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }
        if (memo[i][m] != 0) {
            return memo[i][m];
        }
        int maxStones = 0;
        for (int x = 1; x <= 2 * m; x++) {
            int opponentStones = dp(i + x, Math.max(m, x));
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }
        memo[i][m] = maxStones;
        return maxStones;
    }
}
