class Solution {
    public String longestPalindrome(String s) {

        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            String odd = expand(s, i, i);

            // Even length palindrome
            String even = expand(s, i, i + 1);

            if (odd.length() > answer.length()) {
                answer = odd;
            }

            if (even.length() > answer.length()) {
                answer = even;
            }
        }

        return answer;
    }

    public String expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}