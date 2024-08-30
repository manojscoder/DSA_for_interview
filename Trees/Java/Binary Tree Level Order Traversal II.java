// Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// Time: O(n)
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) {
            queue.offer(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int idx = 0; idx < size; idx++) {
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                } 
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(temp);
        }

        Collections.reverse(result);
        return result;
    }
}
