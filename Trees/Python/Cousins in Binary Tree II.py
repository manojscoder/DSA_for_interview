# Problem link: https://leetcode.com/problems/cousins-in-binary-tree-ii/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue, prev_sum, level = deque([root]), 0, 0

        while queue:
            pst_sum = 0

            for _ in range(len(queue)):
                node = queue.popleft()

                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
                
                if level > 0:
                    left_val = node.left.val if node.left else 0
                    right_val = node.right.val if node.right else 0

                    if node.left:
                        pst_sum += node.left.val
                        node.left.val = (left_val + right_val) * -1
                    
                    if node.right:
                        pst_sum += node.right.val
                        node.right.val = (left_val + right_val) * -1
                    
                node.val = prev_sum + node.val if level > 1 else 0
            
            prev_sum, level = pst_sum, level + 1
        
        return root
