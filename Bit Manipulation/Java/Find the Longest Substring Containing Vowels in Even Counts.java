// Problem link: https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int findTheLongestSubstring(String s) {
        int[] store = new int[26], prev_idx = new int[32];
        int result = 0, mask = 0;

        Arrays.fill(prev_idx, -1);
        store[0] = 1;
        store[4] = 2;
        store[8] = 4;
        store[14] = 8;
        store[20] = 16;

        for(int idx = 0; idx < s.length(); idx++) {
            if(store[s.charAt(idx) - 'a'] != 0) {
                mask ^= store[s.charAt(idx) - 'a'];
            }

            if(prev_idx[mask] != -1 || mask == 0) {
                result = Math.max(result, idx - prev_idx[mask]);
            }
            else {
                prev_idx[mask] = idx;
            }
        }

        return result;
    }
}
