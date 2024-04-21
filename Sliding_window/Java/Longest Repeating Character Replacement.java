// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
class Solution {
    public int characterReplacement(String s, int k) {
        int[] store = new int[26];
        char[] str = s.toCharArray();
        int start = 0, len = 0, result = 0;

        for(int i = 0; i < str.length; i++){
            store[str[i] - 'A']++;

            len = Math.max(len, store[str[i] - 'A']);

            while(i - start + 1 - len > k){
                store[str[start++] - 'A']--;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
