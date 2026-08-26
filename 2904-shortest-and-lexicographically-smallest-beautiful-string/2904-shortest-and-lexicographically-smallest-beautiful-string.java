class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                int count = 0;

                // Count 1s in current substring
                for (int x = i; x <= j; x++) {
                    if (s.charAt(x) == '1') {
                        count++;
                    }
                }

                if (count == k) {
                    String current = s.substring(i, j + 1);

                    if (ans.equals("") ||
                        current.length() < ans.length() ||
                        (current.length() == ans.length() &&
                         current.compareTo(ans) < 0)) {

                        ans = current;
                    }
                }
            }
        }

        return ans;
    }
}