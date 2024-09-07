// Problem link: https://leetcode.com/problems/linked-list-in-binary-tree/description
// Time: O(n * m)
// Space: O(n + m)
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) {
            return false;
        }
        return this.check(head, root) || this.isSubPath(head, root.left) || this.isSubPath(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        else if(root == null || head.val != root.val) {
            return false;
        }
        return this.check(head.next, root.left) || this.check(head.next, root.right);
    }
}
