// problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int flag = 0;

        if(root != null) {
            queue.offer(root);
        }

        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for(int idx = 0; idx < size; idx++) {
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(flag == 1) {
                Collections.reverse(temp);
            }
            flag = flag == 1 ? 0 : 1;
            result.add(temp);
        }

        return result;
    }
}
