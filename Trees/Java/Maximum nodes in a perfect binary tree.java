// Time: O(n)
// Space: O(n)
class Main {
  int result = 0;
  public static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
  
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
  
        if (left[0] == left[1] && left[1] == right[0] && right[0] == right[1]) {
            result = Math.max(result, (int)Math.pow(2, right[1] + 1) - 1);
        }
  
        int minDepth = 1 + Math.min(left[0], right[0]);
        int maxDepth = 1 + Math.max(left[1], right[1]);
  
        return new int[]{minDepth, maxDepth};
  }
}
