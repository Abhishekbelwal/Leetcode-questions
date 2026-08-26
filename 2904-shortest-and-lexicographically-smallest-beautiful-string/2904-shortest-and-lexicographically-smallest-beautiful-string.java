class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";

        int left = 0;
        int ones = 0;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // We have more than k ones
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Exactly k ones
            if (ones == k) {

                // Remove unnecessary zeros from left
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length() &&
                     current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}