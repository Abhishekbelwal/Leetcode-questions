class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        dp[0] = 1; // empty subsequence

        int[] last = new int[26];
        Arrays.fill(last, -1);

        long MOD = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';

            // Every previous subsequence can either
            // take or not take current character
            dp[i] = 2 * dp[i - 1];

            // Remove duplicates created by previous occurrence
            if (last[ch] != -1) {
                dp[i] -= dp[last[ch] - 1];
            }

            dp[i] = (dp[i] + MOD) % MOD;

            last[ch] = i;
        }

        // Remove empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}