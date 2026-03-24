import java.util.Arrays;
/*
Your current approach is incorrect because:

It does not compute the maximum non-adjacent subsequence sum.

It does not recompute the answer after each query properly.

It simply adds neighbors of updated indices.

Time complexity would be too slow if we recomputed DP from scratch for each query (O(n × q)).

✅ Correct Approach

This is a dynamic programming + segment tree problem.

The core problem is the classic:

Maximum sum of subsequence with no two adjacent elements
(a.k.a. House Robber problem)

For a static array, we use:

dp[i] = max(dp[i-1], dp[i-2] + nums[i])

But since we must:

Update elements (point updates)

Recalculate answer after each update

n, q ≤ 5 * 10^4

We need O(log n) per update, so we use a Segment Tree with DP states.

🔥 Key Idea

For each segment tree node, store 4 states:

Let:

0 = first element NOT taken

1 = first element taken

Each node stores a 2×2 matrix:

dp[a][b]

Where:

a = whether left boundary is taken

b = whether right boundary is taken

This allows safe merging of two segments without breaking adjacency rules.

🧠 Merge Logic

When merging left node (L) and right node (R):

We must ensure:

L.right_taken and R.left_taken cannot both be 1

So while merging:

for all a,b:
   for all mid states:
       if not (L.right == 1 AND R.left == 1):
            combine
⏱ Complexity

Build: O(n)

Each update: O(log n)

Total: O((n + q) log n)

Works for 5 * 10⁴ constraints.
*/
public class Solution {

    static class Node {
        long[][] dp = new long[2][2];

        Node() {
            for (int i = 0; i < 2; i++)
                Arrays.fill(dp[i], Long.MIN_VALUE);
        }
    }

    static int MOD = 1_000_000_007;
    static Node[] tree;
    static int n;

    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        n = nums.length;
        tree = new Node[4 * n];
        build(nums, 0, 0, n - 1);

        long total = 0;

        for (int[] q : queries) {
            update(0, 0, n - 1, q[0], q[1]);
            Node root = tree[0];

            long best = 0;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    best = Math.max(best, root.dp[i][j]);

            total = (total + best) % MOD;
        }

        return (int) total;
    }

    static void build(int[] nums, int idx, int l, int r) {
        tree[idx] = new Node();

        if (l == r) {
            tree[idx].dp[0][0] = 0;           // not take
            tree[idx].dp[1][1] = nums[l];     // take
            tree[idx].dp[0][1] = Long.MIN_VALUE;
            tree[idx].dp[1][0] = Long.MIN_VALUE;
            return;
        }

        int mid = (l + r) / 2;
        build(nums, 2 * idx + 1, l, mid);
        build(nums, 2 * idx + 2, mid + 1, r);

        tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    static void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            tree[idx].dp[0][0] = 0;
            tree[idx].dp[1][1] = val;
            tree[idx].dp[0][1] = Long.MIN_VALUE;
            tree[idx].dp[1][0] = Long.MIN_VALUE;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(2 * idx + 1, l, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, r, pos, val);

        tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    static Node merge(Node left, Node right) {
        Node res = new Node();

        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {

                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {

                        if (x == 1 && y == 1) continue; // adjacent conflict

                        if (left.dp[a][x] == Long.MIN_VALUE ||
                            right.dp[y][b] == Long.MIN_VALUE)
                            continue;

                        res.dp[a][b] = Math.max(
                            res.dp[a][b],
                            left.dp[a][x] + right.dp[y][b]
                        );
                    }
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 9};
        int[][] queries = {{1, -2}, {0, -3}};
        System.out.println(maximumSumSubsequence(nums, queries)); // 21
    }
}