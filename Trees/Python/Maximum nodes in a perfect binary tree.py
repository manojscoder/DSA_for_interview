# Time: O(n)
# Space: O(n)
result = 0
def dfs(root):
    global result
    if not root:
        return [0, 0]
    
    left = dfs(root.left)
    right = dfs(root.right)
    
    if left[0] == left[1] == right[0] == right[1]:
        result = max(result, 2 ** (right[1] + 1) - 1)
    
    minDepth = 1 + min(left[0], right[0])
    maxDepth = 1 + max(left[1], right[1])
    
    return [minDepth, maxDepth]
