// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
// Time: O(log n)
// Space: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val > root.val && q.val > root.val)
                root = root.right;
            else if(p.val < root.val && q.val < root.val)   
                root = root.left;
            else
                return root;
        }

        return root;
    }
}
