// Proiblem link: https://leetcode.com/problems/trim-a-binary-search-tree/description/
// Time: O(log n)
// Space: O(log n0 for call stack
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        
        if(root.val < low)
            return this.trimBST(root.right, low, high);
        
        if(root.val > high)
            return this.trimBST(root.left, low, high);
        
        root.left = this.trimBST(root.left, low, high);
        root.right = this.trimBST(root.right, low, high);
    
        return root;
    }
}
