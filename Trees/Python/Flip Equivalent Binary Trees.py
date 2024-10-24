# Problem link: https://leetcode.com/problems/flip-equivalent-binary-trees/description/
# Time: O(n)
# Space: O(n)

class Solution:
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        return self.dfs(root1, root2)
    
    def dfs(self, root1, root2):
        if not root1 and not root2:
            return True
        elif not root1 or not root2 or root1.val != root2.val:
            return False
        
        
        result_1 = self.dfs(root1.left, root2.right) and self.dfs(root1.right, root2.left)
        result_2 = self.dfs(root1.left, root2.left) and self.dfs(root1.right, root2.right)

        return result_1 or result_2
