// Problem link: https://leetcode.com/problems/count-complete-tree-nodes/description/
// Time: O((log n) ^ 2)
// Space: O(log n)
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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftHeight = this.getLeftHeight(root);
        int rightHeight = this.getRightHeight(root);

        if(leftHeight == rightHeight)
            return (int)Math.pow(2, leftHeight) - 1;
        
        return 1 + this.countNodes(root.left) + this.countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {
        int count = 0;

        while(root != null) {
            count++;
            root = root.left;
        }

        return count;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;

        while(root != null) {
            count++;
            root = root.right;
        }

        return count;
    }
}
