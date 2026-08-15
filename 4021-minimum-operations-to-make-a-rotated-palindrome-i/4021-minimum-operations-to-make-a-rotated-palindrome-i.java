class Solution {
    public int minOperations(String s) {

        int n = s.length();
        int ans = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {

            int cost = r;   // r rotations

            for (int i = 0; i < n / 2; i++) {

                char left = s.charAt((i + r) % n);
                char right = s.charAt((n - 1 - i + r) % n);

                int diff = Math.abs(left - right);

                cost += Math.min(diff, 26 - diff);
            }

            ans = Math.min(ans, cost);
        }

        return ans;
    }
}