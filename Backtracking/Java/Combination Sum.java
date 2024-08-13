// Problem link: https://leetcode.com/problems/combination-sum/description/
// Time: O(2 ^ n)
// Space: O(n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        this.backtrack(result, curr, candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target,int index) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
        }
        if(target <= 0) {
            return;
        }

        for(int idx = index; idx < candidates.length; idx++) {
            curr.add(candidates[idx]);
            this.backtrack(result, curr, candidates, target - candidates[idx], idx);
            curr.remove(curr.size() - 1);
        }
    }
}
