// Problem link: https://leetcode.com/problems/flip-equivalent-binary-trees/description/
// Tiem: O(n)
// Space: O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return this.dfs(root1, root2);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        else if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        boolean result_1 = this.dfs(root1.left, root2.right) && this.dfs(root1.right, root2.left);
        boolean result_2 = this.dfs(root1.left, root2.left) && this.dfs(root1.right, root2.right);

        return result_1 || result_2;
    }
}
