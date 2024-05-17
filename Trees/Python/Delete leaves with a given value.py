# Problem link: https://leetcode.com/problems/delete-leaves-with-a-given-value/description
# Time: O(n)
# Space: O(n)

# Recursive approach
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:

        def dfs(node):
            if not node:
                return None
            
            node.left = dfs(node.left)
            node.right = dfs(node.right)
            if node.left is None and node.right is None and node.val == target:
                return None
                
            return node
    
        return dfs(root)

# Iterative approach
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        stack, visit, parents = [root], set(), {root : None}

        while stack:
            node = stack.pop()

            if not node.left and not node.right and node.val == target:
                prt = parents[node]
                if not prt:
                    return None
                
                if prt.left == node:
                    prt.left = None
                elif prt.right == node:
                    prt.right = None
                
            elif node not in visit:
                visit.add(node)
                stack.append(node)

                if node.left:
                    stack.append(node.left)
                    parents[node.left] = node
                    
                if node.right:
                    stack.append(node.right)
                    parents[node.right] = node

        return root
