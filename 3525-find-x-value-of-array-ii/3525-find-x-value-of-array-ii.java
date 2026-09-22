import java.util.*;

class Solution {
    static class Node {
        int prod;
        int[] remain;

        Node(int k) {
            this.prod = 1;
            this.remain = new int[k];
        }
    }

    private int n;
    private int k;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];
        
        build(0, 0, n - 1, nums);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Persistent update
            update(0, 0, n - 1, idx, val);

            // 2. Query the range from start to the end of the array
            Node res = query(0, 0, n - 1, start, n - 1);
            ans[i] = res.remain[x];
        }

        return ans;
    }

    private void build(int node, int start, int end, int[] nums) {
        tree[node] = new Node(k);
        if (start == end) {
            int val = nums[start] % k;
            tree[node].prod = val;
            tree[node].remain[val] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node + 1, start, mid, nums);
        build(2 * node + 2, mid + 1, end, nums);
        merge(tree[node], tree[2 * node + 1], tree[2 * node + 2]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int newVal = val % k;
            Arrays.fill(tree[node].remain, 0);
            tree[node].prod = newVal;
            tree[node].remain[newVal] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }
        merge(tree[node], tree[2 * node + 1], tree[2 * node + 2]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node + 1, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 2, mid + 1, end, l, r);
        }
        Node leftRes = query(2 * node + 1, start, mid, l, r);
        Node rightRes = query(2 * node + 2, mid + 1, end, l, r);
        Node parentNode = new Node(k);
        merge(parentNode, leftRes, rightRes);
        return parentNode;
    }

    private void merge(Node parent, Node left, Node right) {
        parent.prod = (left.prod * right.prod) % k;
        
        // Copy left counts directly
        for (int i = 0; i < k; i++) {
            parent.remain[i] = left.remain[i];
        }
        
        // Shift right counts by left.prod and add them to parent
        int leftProd = left.prod;
        for (int j = 0; j < k; j++) {
            if (right.remain[j] > 0) {
                int newRem = (j * leftProd) % k;
                parent.remain[newRem] += right.remain[j];
            }
        }
    }
}
