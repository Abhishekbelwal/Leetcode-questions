import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Step 1: Precompute Pascal's Triangle for combinations nCr % MOD
        table = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }
        
        // Step 2: Convert primitive array to a List for easier partitioning
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        // Step 3: Run the DFS and subtract 1 to exclude the original array configuration
        long totalWays = dfs(list);
        return (int) ((totalWays - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> list) {
        // Base case: arrays with 2 or fewer elements have only 1 way to be ordered
        if (list.size() <= 2) {
            return 1;
        }

        // The first element is always the root of the current subtree
        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition remaining elements into left (smaller) and right (larger) subtrees
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        // Recursively find the ways for the left and right subtrees
        long leftWays = dfs(left);
        long rightWays = dfs(right);

        // Interleave the subtrees using the precomputed combination table
        long waysToInterleave = table[left.size() + right.size()][left.size()];

        // Multiply all factors together under modulo
        return (((waysToInterleave * leftWays) % MOD) * rightWays) % MOD;
    }
}
