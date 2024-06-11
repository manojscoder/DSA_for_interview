// Problem link: https://leetcode.com/problems/combination-sum-ii/description/
// Time: 2 ^ n
// Space: O(n)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        this.backTrack(target, curr, result, 0, candidates);
        return result;
    }

    private void backTrack(int target, List<Integer> curr, List<List<Integer>> res, int index, int[] candidates) {
        if(target == 0)
            res.add(new ArrayList<>(curr));
        if(target <= 0)
            return;
        
        int prev = -1;
        for(int i = index; i < candidates.length; i++) {
            if(prev != candidates[i]) {
                curr.add(candidates[i]);
                this.backTrack(target - candidates[i], curr, res, i + 1, candidates);
                curr.remove(curr.size() - 1);
                prev = candidates[i];
            }
        }
    }
}
