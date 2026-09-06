class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
      
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        // Iterate through string s
        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i - 1);
            // Iterate backwards through t to use values from the previous iteration safely
            for (int j = n; j > 0; j--) {
                char tChar = t.charAt(j - 1);
                
                // If characters match, we have two choices:
                // 1. Match the current characters: dp[j-1]
                // 2. Ignore this character in s and use previous matches: dp[j]
                if (sChar == tChar) {
                    dp[j] = dp[j] + dp[j - 1];
                }
                // If they don't match, dp[j] remains the same (dp[j] = dp[j])
            }
        }
        
        return dp[n];
    }
}
