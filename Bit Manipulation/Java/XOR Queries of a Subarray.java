// Problem link: https://leetcode.com/problems/xor-queries-of-a-subarray/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int size = arr.length;
        int[] store = new int[size + 1];
        int[] result = new int[queries.length];

        for(int idx = 0; idx < size; idx++) {
            store[idx + 1] = store[idx] ^ arr[idx];
        }

        for(int idx = 0; idx < queries.length; idx++) {
            result[idx] = store[queries[idx][1] + 1] ^ store[queries[idx][0]]; 
        }

        return result;
    }
}
