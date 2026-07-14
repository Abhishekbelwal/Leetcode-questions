import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        // Find the maximum value in the array to bound our DP state space
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // dp[x][y] stores the number of disjoint pairs with GCDs x and y
        int[][] dp = new int[maxNum + 1][maxNum + 1];
        dp[0][0] = 1; // Base case: both subsequences are empty

        for (int num : nums) {
            int[][] nextDp = new int[maxNum + 1][maxNum + 1];
            
            for (int x = 0; x <= maxNum; x++) {
                for (int y = 0; y <= maxNum; y++) {
                    if (dp[x][y] == 0) continue;

                    long count = dp[x][y];

                    // Option 1: Skip the current number
                    nextDp[x][y] = (int) ((nextDp[x][y] + count) % MOD);

                    // Option 2: Include the current number in the first subsequence
                    int nextX = gcd(x, num);
                    nextDp[nextX][y] = (int) ((nextDp[nextX][y] + count) % MOD);

                    // Option 3: Include the current number in the second subsequence
                    int nextY = gcd(x, num); // calculating new gcd for sequence 2
                    int newY = gcd(y, num);
                    nextDp[x][newY] = (int) ((nextDp[x][newY] + count) % MOD);
                }
            }
            dp = nextDp;
        }

        // Sum up all valid pairs where both subsequences are non-empty (g > 0) and have equal GCD
        long totalPairs = 0;
        for (int g = 1; g <= maxNum; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
    }

    // Helper method to calculate Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
