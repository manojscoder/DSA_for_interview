# Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
# Time: O(n)
# Space: O(n)# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        result, queue = [], deque()

        if root:
            queue.append(root)
        
        while queue:
            temp = []

            for _ in range(len(queue)):
                node = queue.popleft()
                temp.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            result.append(temp)

        return result[::-1]
