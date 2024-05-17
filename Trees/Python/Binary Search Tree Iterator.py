# Problem link: https://leetcode.com/problems/binary-search-tree-iterator/description/
# Time: O(n)
# Space: O(h) where h is height of the tree

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.travel(root)

    def next(self) -> int:
        node = self.stack.pop()
        self.travel(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0

    def travel(self, node) -> None:
        while node:
            self.stack.append(node)
            node = node.left
