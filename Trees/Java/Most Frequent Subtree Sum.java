// Problem link: https://leetcode.com/problems/most-frequent-subtree-sum/description/
// Time: O(n)
// Space: O(n)
class Solution {
    HashMap<Integer, Integer> store;
    public int[] findFrequentTreeSum(TreeNode root) {
        this.store = new HashMap<>();

        this.dfs(root);
        int res = 0, count = 0;
        for(int val : this.store.values()){
            res = Math.max(res, val);
        }

        for(int key : this.store.keySet()){
            if(this.store.get(key) == res){
                count++;
            }
        }

        int[] result = new int[count];

        for(int key : this.store.keySet()){
            if(this.store.get(key) == res){
                result[--count] = key;
            }
        }

        return result;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int currSum = root.val + this.dfs(root.left) + this.dfs(root.right);
        this.store.put(currSum, this.store.getOrDefault(currSum, 0) + 1);
        return currSum;
    }
}
