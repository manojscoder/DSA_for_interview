// Problem link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
// Time: O(n)
// Space: O(n)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int max, size;
        TreeNode node;
        queue.offer(root);

        while(!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            size = queue.size();

            for(int index = 0; index < size; index++) {
                node = queue.poll();
                max = Math.max(node.val, max);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}
