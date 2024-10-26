# Problem link: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/
# Time: O(n + q)
# Space: O(n)

class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        nodeLevel, nodeHeight, topTwoHeight, result = {}, {}, {}, []
    
        self.preProcess(root, nodeLevel, nodeHeight, topTwoHeight, 0)

        for node in queries:
            level, height = nodeLevel[node], nodeHeight[node]
            if height == topTwoHeight[level][0]:
                result.append(topTwoHeight[level][1] + level - 1)
            else:
                result.append(topTwoHeight[level][0] + level - 1)

        return result
    
    def preProcess(self, node, nodeLevel, nodeHeight, topTwoHeight, level):
        if not node:
            return 0
        
        leftHeight = self.preProcess(node.left, nodeLevel, nodeHeight, topTwoHeight, level + 1)
        rightHeight = self.preProcess(node.right, nodeLevel, nodeHeight, topTwoHeight, level + 1)

        height = 1 + max(leftHeight, rightHeight)

        if level not in topTwoHeight:
            topTwoHeight[level] = [0, 0] 
        
        nodeLevel[node.val] = level
        nodeHeight[node.val] = height

        if topTwoHeight[level][0] < height:
            topTwoHeight[level][0], topTwoHeight[level][1] = height, topTwoHeight[level][0]
        elif topTwoHeight[level][1] < height:
            topTwoHeight[level][1] = height
        
        return height
