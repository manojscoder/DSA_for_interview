# Problem link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description
# Time: O(n)
# Space: O(n)
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        startIdx = destIdx = 0

        startPath = self.dfs(root, startValue, [])
        destPath = self.dfs(root, destValue, [])

        while startIdx < len(startPath) and destIdx < len(destPath):
            if startPath[startIdx] != destPath[destIdx]:
                break
            startIdx, destIdx = startIdx + 1, destIdx + 1
        
        return 'U' * (len(startPath) - startIdx) + "".join(destPath[destIdx:])
    
    def dfs(self, root, value, path):
        if not root:
            return []
        
        if root.val == value:
            return path
        
        path.append('L')
        left = self.dfs(root.left, value, path)
        if left:
            return path
        
        path.pop()
        path.append('R')
        right = self.dfs(root.right, value, path)
        if right:
            return right
        
        path.pop()
        return []
