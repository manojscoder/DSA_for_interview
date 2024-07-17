// Problem link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description
// Time: O(n)
// Space: O(n)
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> startPath = this.dfs(root, startValue, new ArrayList<>());
        List<Character> destPath = this.dfs(root, destValue, new ArrayList<>());
        StringBuilder result = new StringBuilder();

        int startIdx = 0, destIdx = 0;

        while(startIdx < startPath.size() && destIdx < destPath.size()) {
            if(startPath.get(startIdx) != destPath.get(destIdx)) {
                break;
            }
            startIdx += 1;
            destIdx += 1;
        }

        for(int idx = startIdx; idx < startPath.size(); idx++) {
            result.append('U');
        }

        for(int idx = destIdx; idx < destPath.size(); idx++) {
            result.append(destPath.get(idx));
        }

        return result.toString();
    }

    private List<Character> dfs(TreeNode root, int value, List<Character> path) {
        if(root == null) {
            return new ArrayList<>();
        }

        if(root.val == value) {
            return path;
        }

        path.add('L');
        List<Character> left = this.dfs(root.left, value, path);
        if(left.size() > 0) {
            return path;
        }

        path.remove(path.size() - 1);
        path.add('R');
        List<Character> right = this.dfs(root.right, value, path);
        if(right.size() > 0) {
            return path;
        }

        path.remove(path.size() - 1);
        return new ArrayList<>();
    }
}
