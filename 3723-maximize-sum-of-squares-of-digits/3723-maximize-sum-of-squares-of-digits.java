import java.util.Arrays;

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // If it's impossible to reach the sum with 'num' digits
        if (sum > 9 * num) {
            return "";
        }

        char[] result = new char[num];
        
        // Fill with '0' as the default background
        Arrays.fill(result, '0');

        // Greedily place the largest possible digits from left to right
        for (int i = 0; i < num && sum > 0; i++) {
            int digit = Math.min(9, sum);
            result[i] = (char) ('0' + digit);
            sum -= digit;
        }

        return new String(result);
    }
}
