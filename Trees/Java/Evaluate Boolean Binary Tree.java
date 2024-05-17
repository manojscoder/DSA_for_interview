// Problem link: https://leetcode.com/problems/evaluate-boolean-binary-tree/description
// Time: O(n)
// Space: O(n)

// Recursive approach
class Solution {
    public boolean evaluateTree(TreeNode node) {
        if (node.left == null) {
            return node.val == 1;
        }

        if (node.val == 2) {
            return evaluateTree(node.left) || evaluateTree(node.right);
        } else {
            return evaluateTree(node.left) && evaluateTree(node.right);
        }
    }
}

// Iterative approach
class Solution {
    public boolean evaluateTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> store = new HashMap<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null) {
                store.put(node, node.val == 1);
            } else {
                if (store.containsKey(node.left) && store.containsKey(node.right)) {
                    boolean leftEval = store.get(node.left);
                    boolean rightEval = store.get(node.right);
                    store.put(node, node.val == 2 ? leftEval || rightEval : leftEval && rightEval);
                } else {
                    stack.push(node);
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                }
            }
        }
        
        return store.get(root);
    }
}
