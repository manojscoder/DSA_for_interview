// Problem link: https://leetcode.com/problems/binary-tree-right-side-view/description/
// Time: O(n)
// Space: O(n)

// DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, int level) {
        if(node == null) {
            return;
        }
        else if(result.size() == level) {
            result.add(node.val);
        }
        this.dfs(node.right, result, level + 1);
        this.dfs(node.left, result, level + 1);
    }
}

// BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = null;
        int size;

        if(root != null) {
            queue.offer(root);
        }

        while(!queue.isEmpty()) {
            size = queue.size();

            for(int idx = 0; idx < size; idx++) {
                node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(node.val);
        }

        return result;
    }
}
