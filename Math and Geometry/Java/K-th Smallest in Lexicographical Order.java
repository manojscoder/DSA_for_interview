// Problem link: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
// Time: O(log n)
// Space: O(1)
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        int idx = 1;

        while(idx < k) {
            int count = helper(curr, n);

            if(idx + count <= k) {
                idx += count;
                curr += 1;
            } 
            else {
                curr *= 10;
                idx += 1;
            }
        }

        return curr;
    }

    private int helper(int curr, int n) {
        int count = 0;
        long first = curr, next = curr + 1;

        while(first <= n) {
            count += Math.min(n + 1L, next) - first;
            first *= 10;
            next *= 10;
        }

        return count;
    }
}
