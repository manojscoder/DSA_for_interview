# Problem link: https://leetcode.com/problems/house-robber-iii/description/ 
# Time: O(n)
# Space: O(n)
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        
        def dfs(node):
            if not node:
                return [0, 0]
            
            left = dfs(node.left)
            right = dfs(node.right)
            return [node.val + left[1] + right[1], max(left) + max(right)]
        
        return max(dfs(root))
