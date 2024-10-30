// Problem link: https://leetcode.com/problems/path-sum-iii/description/
// Time: O(n)
// Space: O(1)

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> lookUp = new HashMap<>();
        lookUp.put((long)0, 1);
        return this.dfs(root, targetSum, 0, lookUp);
    }

    private int dfs(TreeNode node, int target, long currSum, Map<Long, Integer> lookUp) {
        if(node == null) {
            return 0;
        }

        currSum += node.val;
        int count = lookUp.getOrDefault(currSum - target, 0);

        lookUp.put(currSum, lookUp.getOrDefault(currSum, 0) + 1);
        count += this.dfs(node.left, target, currSum, lookUp) + this.dfs(node.right, target, currSum, lookUp);
        lookUp.put(currSum, lookUp.get(currSum) - 1);

        return count;
    }
}
