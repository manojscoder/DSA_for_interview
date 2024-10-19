// Problem link: https://leetcode.com/problems/k-th-symbol-in-grammar/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int kthGrammar(int n, int k) {
        int left = 0, right = (int)Math.pow(2, n - 1) - 1, result = 0, mid;

        for(int idx = 0; idx < n - 1; idx++) {
            mid = (left + right) / 2;

            if(mid >= k - 1) {
                right = mid;
            }
            else {
                left = mid + 1;
                result = result == 1 ? 0 : 1;
            }
        }

        return result;
    }
}
