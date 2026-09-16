class Solution {
    public int numberOfSets(int n, int k) {
        long mod = 1_000_000_007;

        long[][] dp = new long[k + 1][2];

        // 0 segments completed and currently not drawing
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= k; j++) {

                // Close an existing segment OR remain outside
                dp[j][0] = (dp[j][0] + dp[j][1]) % mod;

                // Continue existing segment
                // OR start a new segment
                dp[j][1] = (dp[j][1] + dp[j - 1][0]) % mod;
            }
        }

        return (int) ((dp[k][0] + dp[k][1]) % mod);
    }
}