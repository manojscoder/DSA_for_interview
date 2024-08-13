// Problem link: https://leetcode.com/problems/combinations/description/
// Time: O(2 ^ n)
// Space: O(n)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        this.backtrack(result, curr, n, k, 1);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int n, int k, int index) {
        if(curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int idx = index; idx <= n; idx++) {
            curr.add(idx);
            this.backtrack(result, curr, n, k, idx + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
