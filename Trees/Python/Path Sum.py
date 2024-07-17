# Problem link: https://leetcode.com/problems/path-sum/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.dfs(root, targetSum, 0)
    
    def dfs(self, root, targetSum, preSum):
        if not root:
            return False

        preSum += root.val
        
        if not root.left and not root.right and preSum == targetSum:
            return True
        
        return self.dfs(root.left, targetSum, preSum) or self.dfs(root.right, targetSum, preSum)
