// Problem link: https://leetcode.com/problems/distribute-coins-in-binary-tree/description
// Time: O(n)
// Space: O(n) for recursive call stack
class Solution {
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l_extra = dfs(node.left);
        int r_extra = dfs(node.right);

        int extra_coins = node.val - 1 + l_extra + r_extra;

        res += Math.abs(extra_coins);
        return extra_coins;
    }
}
