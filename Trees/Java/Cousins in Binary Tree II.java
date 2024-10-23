// Problem link: https://leetcode.com/problems/cousins-in-binary-tree-ii/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int pst_sum = 0, prev_sum = 0, level = 0, left_val, right_val, size;
        TreeNode node;
        queue.offer(root);

        while(!queue.isEmpty()) {
            size = queue.size();
            pst_sum = 0;

            for(int idx = 0; idx < size; idx++) {
                node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }

                if(level > 0) {
                    left_val = node.left != null ? node.left.val : 0;
                    right_val = node.right != null ? node.right.val : 0;

                    if(node.left != null) {
                        pst_sum += node.left.val;
                        node.left.val = (left_val + right_val) * -1;
                    }

                    if(node.right != null) {
                        pst_sum += node.right.val;
                        node.right.val = (left_val + right_val) * -1;
                    }
                }

                node.val = level > 1 ? prev_sum + node.val : 0;
            }

            prev_sum = pst_sum;
            level++;
        }

        return root;
    }
}
