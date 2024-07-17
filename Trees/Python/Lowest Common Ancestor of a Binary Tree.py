# Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
# Time: O(n)
# Space: O(n) for call stack
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root, p, q)
    
    def dfs(self, root, p, q):
        if not root or root == p or root == q:
            return root
        
        left = self.dfs(root.left, p, q)
        right = self.dfs(root.right, p, q)

        if not left:
            return right
        elif not right:
            return left
        return root
