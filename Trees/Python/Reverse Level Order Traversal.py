# Problem link: https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1
# Time: O(n)
# Space: O(n)
def reverseLevelOrder(root):
    data = []
    
    q = deque()
    q.append(root)
    
    while q:
        node = q.popleft()
        data.append(node.data)
        if node.right:
            q.append(node.right)
        if node.left:
            q.append(node.left)
    
    return data[::-1]
