# Problem link: https://leetcode.com/problems/distribute-coins-in-binary-tree/description
# Time: O(n)
# Space: O(n) for recursive call stack
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        def dfs(node):
            if not node:
                return 0
            
            l_extra = dfs(node.left)
            r_extra = dfs(node.right)

            extra_coins = node.val - 1 + l_extra + r_extra

            self.res += abs(extra_coins)
            return extra_coins
        
        dfs(root)
        return self.res
