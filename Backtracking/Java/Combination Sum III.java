// Problem link: https://leetcode.com/problems/combination-sum-iii/
// Time: O(9 ^ k)
// Space: O(k)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for(int num = 1; num < 10; num++) {
            curr.add(num);
            this.backTrack(num, num, result, k, n, curr);
            curr.remove(0);
        }

        return result;
    }

    private void backTrack(int num, int total, List<List<Integer>> result, int k, int n, List<Integer> curr) {
        if(total == n && curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int nxt = num + 1; nxt < 10; nxt++) {
            if(total + nxt > n) {
                break;
            }
            curr.add(nxt);
            this.backTrack(nxt, total + nxt, result, k, n, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
