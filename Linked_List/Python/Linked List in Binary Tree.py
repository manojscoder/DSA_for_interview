# Problem link: https://leetcode.com/problems/linked-list-in-binary-tree/description
# Time: O(n * m)
# Space: O(n + m)
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        if not root:
            return False
        return self.check(head, root) or self.isSubPath(head, root.left) or self.isSubPath(head, root.right)
        
    def check(self, listNode, treeNode):
        if not listNode:
            return True
        elif not treeNode or listNode.val != treeNode.val:
            return False
        
        return self.check(listNode.next, treeNode.left) or self.check(listNode.next, treeNode.right)
