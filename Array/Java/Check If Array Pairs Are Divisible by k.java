// Problem link: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description
// Time: O(n)
// Space: O(k)
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] store = new int[k];
        int left = 1, right = k - 1;

        for(int idx = 0; idx < arr.length; idx++) {
            store[((arr[idx] % k) + k) % k]++;
        }

        while(left <= right) {
            if(store[left++] != store[right--]) {
                return false;
            }
        }

        return store[0] % 2 == 0;
    }
}
