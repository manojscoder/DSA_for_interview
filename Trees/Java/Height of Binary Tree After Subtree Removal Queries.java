// Problem link: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/
// Time: O(n + q)
// Space: O(n)

class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int size = this.count(root);
        int[] nodeLevel = new int[size + 1], nodeHeight = new int[size + 1], result = new int[queries.length];
        int[][] topTwoHeight = new int[size + 1][2];

        int height = this.preProcess(root, nodeLevel, nodeHeight, topTwoHeight, 0), level;

        for(int idx = 0; idx < queries.length; idx++) {
            height = nodeHeight[queries[idx]];
            level = nodeLevel[queries[idx]];

            if(topTwoHeight[level][0] == height) {
                result[idx] = topTwoHeight[level][1] + level - 1;
            }
            else {
                result[idx] = topTwoHeight[level][0] + level - 1;
            }
        }

        return result;
    }

    private int preProcess(TreeNode node, int[] nodeLevel, int[] nodeHeight, int[][] topTwoHeight, int level) {
        if(node == null) {
            return 0;
        }

        int leftHeight = this.preProcess(node.left, nodeLevel, nodeHeight, topTwoHeight, level + 1);
        int rightHeight = this.preProcess(node.right, nodeLevel, nodeHeight, topTwoHeight, level + 1);
        int height = 1 + Math.max(leftHeight, rightHeight);

        nodeLevel[node.val] = level;
        nodeHeight[node.val] = height;


        if(topTwoHeight[level][0] < height) {
            topTwoHeight[level][0] += height;
            topTwoHeight[level][1] = topTwoHeight[level][0] - height;
            topTwoHeight[level][0] -= topTwoHeight[level][1];
        }
        else if(topTwoHeight[level][1] < height) {
            topTwoHeight[level][1] = height;
        }

        return height;
    }

    private int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + this.count(root.left) + this.count(root.right);
    }
}
