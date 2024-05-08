# Problem link: https://www.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
# Time: O(nlogn)
# Space: O(n)
def noSibling(root):
    result = []
    def find(node):
        if not node:
            return
        
        if not node.left or not node.right:
            if node.left:
                result.append(node.left.data)
            elif node.right:
                result.append(node.right.data)

        find(node.left)
        find(node.right)

    find(root)
    
    result.sort()
    return [-1] if len(result) == 0 else result
