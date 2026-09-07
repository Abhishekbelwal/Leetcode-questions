class Solution {
    public int distinctSubseqII(String s) {
        long[] end = new long[26];

        long total = 0;
        long MOD = 1_000_000_007;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            long newSubsequences = (total + 1) % MOD;

            total = (total + newSubsequences - end[index] + MOD) % MOD;

            end[index] = newSubsequences;
        }

        return (int) total;
    }
}