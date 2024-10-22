// Problem link: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
// Time: O(n * log h)
// Space: O(n)
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        long total;
        TreeNode node;
        int size;

        queue.offer(root);

        while(!queue.isEmpty()) {

            total = 0;
            size = queue.size();

            for(int itr = 0; itr < size; itr++) {

                node = queue.poll();
                total += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            minHeap.offer(total);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
