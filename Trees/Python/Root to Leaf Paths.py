# Problem link: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
# Time: O(n)
# Space: O(height of the tree)
class Solution:
    def Paths(self, root : Optional['Node']) -> List[List[int]]:
        result, lst = [], []
        
        def dfs(node):
            if node and not node.left and not node.right:
                lst.append(node.data)
                result.append(lst[:])
                lst.pop()
            elif node:
                lst.append(node.data)
                dfs(node.left)
                dfs(node.right)
                lst.pop()
        
        dfs(root)
        
        return result
