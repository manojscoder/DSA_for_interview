# Problem link: https://leetcode.com/problems/evaluate-boolean-binary-tree/description
# Time: O(n)
# Space: O(n)

# Recursive approach
class Solution:
    def evaluateTree(self, node: Optional[TreeNode]) -> bool:
        if not node.left:
            return True if node.val == 1 else False
            
        if node.val == 2:
            return self.evaluateTree(node.left) or self.evaluateTree(node.right)
        return self.evaluateTree(node.left) and self.evaluateTree(node.right)

# Iterative approach
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        stack, store = [root], {}
        
        while stack:
            node = stack.pop()
            if not node.left:
                store[node] = node.val == 1
            else:
                if node.left in store:
                    store[node] = store[node.left] or store[node.right] if node.val == 2 else  store[node.left] and store[node.right]
                else:
                    stack.extend([node, node.left, node.right])
        
        return store[root]
