// Problem link: https://leetcode.com/problems/delete-leaves-with-a-given-value/description
// Time: O(n)
// Space: O(n)

// Recursive approach
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, target);
        node.right = dfs(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }
}

// Iterative approach
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visit = new HashSet<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        if (root != null) {
            stack.push(root);
            parents.put(root, null);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null && node.val == target) {
                TreeNode prt = parents.get(node);
                if (prt == null) {
                    return null;
                }

                if (prt.left == node) {
                    prt.left = null;
                } else if (prt.right == node) {
                    prt.right = null;
                }
            } else if (!visit.contains(node)) {
                visit.add(node);
                stack.push(node);

                if (node.left != null) {
                    stack.push(node.left);
                    parents.put(node.left, node);
                }

                if (node.right != null) {
                    stack.push(node.right);
                    parents.put(node.right, node);
                }
            }
        }

        return root;
    }
}
