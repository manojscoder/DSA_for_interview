# Problem link: https://leetcode.com/problems/range-sum-query-mutable/
# Time: O(log n) for sumRange and update methods
# Space: O(n)
class Node:

    def __init__(self, data):
        self.data = data
        self.left = self.right = None

class segmentTree:

    def __init__(self, nums):
        self.size = len(nums)
        self.tree = self.buildTree(0, self.size - 1, nums)
    
    def buildTree(self, low, high, nums):
        if low == high:
            return Node(nums[low])

        mid = (low + high) // 2

        node = Node(-1)
        node.left = self.buildTree(low, mid, nums)
        node.right = self.buildTree(mid + 1, high, nums)
        node.data = node.left.data + node.right.data

        return node
        

    def queryTree(self, node, low, high, left, right):
        if low >= left and high <= right:
            return node.data
        elif low > right or high < left:
            return 0

        mid = (low + high) // 2

        leftSum = self.queryTree(node.left, low, mid, left, right)
        rightSum = self.queryTree(node.right, mid + 1, high, left, right)

        return leftSum + rightSum
    
    def updateTree(self, node, low, high, idx, value):
        if low == high:
            node.data = value
            return

        mid = (low + high) // 2

        if idx <= mid:
            self.updateTree(node.left, low, mid, idx, value)
        else:
            self.updateTree(node.right, mid + 1, high, idx, value)

        node.data = node.left.data + node.right.data

class NumArray:

    def __init__(self, nums: List[int]):
        self.DS = segmentTree(nums)

    def update(self, index: int, val: int) -> None:
        self.DS.updateTree(self.DS.tree, 0, self.DS.size - 1, index, val)

    def sumRange(self, left: int, right: int) -> int:
        return self.DS.queryTree(self.DS.tree, 0, self.DS.size - 1, left, right)
