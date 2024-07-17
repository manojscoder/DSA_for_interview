// Problem link: https://leetcode.com/problems/delete-nodes-and-return-forest
// Time: O(n)
// Space: O(n)
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();

        for(int node : to_delete) {
            deleteSet.add(node);
        }
        
        if(this.dfs(root, deleteSet, result) != null) {
            result.add(root);
        }

        return result;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> deleteSet, List<TreeNode> result) {
        if(root == null) {
            return root;
        }

        root.left = this.dfs(root.left, deleteSet, result);
        root.right = this.dfs(root.right, deleteSet, result);

        if(deleteSet.contains(root.val)) {
            if(root.left != null) {
                result.add(root.left);
            }

            if(root.right != null) {
                result.add(root.right);
            }

            return null;
        }

        return root;
    }
}
