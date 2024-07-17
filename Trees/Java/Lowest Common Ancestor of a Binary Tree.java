// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// Time: O(n)
// Space: O(n) for call stack

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return this.dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = this.dfs(root.left, p, q);
        TreeNode right = this.dfs(root.right, p, q);

        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        return root;
    }
}
