# Problem link: https://leetcode.com/problems/delete-nodes-and-return-forest
# Time: O(n)
# Space: O(n)
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        to_delete, result = set(to_delete), []

        if self.dfs(root, to_delete, result):
            result.append(root)

        return result
    
    def dfs(self, root, to_delete, result):
        if not root:
            return None
        
        root.left = self.dfs(root.left, to_delete, result)
        root.right = self.dfs(root.right, to_delete, result)

        if root.val in to_delete:
            if root.left:
                result.append(root.left)
            if root.right:
                result.append(root.right)
            return None
            
        return root
