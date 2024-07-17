// Problem link: https://leetcode.com/problems/path-sum/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int preSum) {
        if(root == null) {
            return false;
        }

        preSum += root.val;

        if(preSum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return dfs(root.left, targetSum, preSum) || dfs(root.right, targetSum, preSum);
    }
}
