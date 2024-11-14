// Problem link: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
// Time: O(n log max(quantities))
// Space: O(1)
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0, result = -1, mid;

        for(int i : quantities)
            right = Math.max(right, i);

        while(left <= right) {
            mid = (left + right) / 2;

            if(isPossible(quantities, n, mid)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }
    private boolean isPossible(int[] quantities, int n, int diff) {
        int total = 0;

        for(int q : quantities)
            total += Math.ceil((double) q / diff);

        return total <= n;
    }
}
