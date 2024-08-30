# Problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result, flag = [], 0
        queue = deque()

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
            
            if flag:
                result.append(temp[::-1])
            else:
                result.append(temp)
            flag = 0 if flag else 1

        return result
