// Problem link: https://leetcode.com/problems/binary-search-tree-iterator/description/
// Time: O(n)
// Space: O(h) where h is height of the tree
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.travel(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        this.travel(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void travel(TreeNode node){
        while(node != null){
            this.stack.push(node);
            node = node.left;
        }
    }
}
