# Problem link: https://leetcode.com/problems/binary-tree-right-side-view/description/
# Time: O(n)
# Space: O(n)

# DFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.dfs(root, result, 0)
        return result
    
    def dfs(self, node, result, level):
        if not node:
            return
        elif len(result) == level:
            result.append(node.val)
        
        self.dfs(node.right, result, level + 1)
        self.dfs(node.left, result, level + 1)

# BFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result, queue = [], deque()

        if root:
            queue.append(root)

        while queue:
            for idx in range(len(queue)):
                node = queue.popleft()
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(node.val)
        
        return result
