# Problem link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
# Time: O(n)
# Space: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        if not root:
            return result

        queue = deque([root])
        
        while queue:
            maximum = float('-inf')
            for _ in range(len(queue)):
                node = queue.popleft()
                maximum = max(maximum, node.val)

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
            result.append(maximum)

        return result
