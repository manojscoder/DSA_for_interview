# Problem link: https://leetcode.com/problems/path-sum-iii/description/
# Time: O(n)
# Space: O(1)

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        lookUp = defaultdict(int)
        lookUp[0] = 1
        return self.dfs(root, targetSum, 0, lookUp)
    
    def dfs(self, node, target, total, lookUp):
        if not node:
            return 0
        
        total += node.val
        count = lookUp[total - target]

        lookUp[total] += 1
        count += self.dfs(node.left, target, total, lookUp) + self.dfs(node.right, target, total, lookUp)
        lookUp[total] -= 1

        return count
