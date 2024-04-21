// Time: O(n)
// Space: O(n)
// Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, result = 0;
        char[] str = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            while(set.contains(str[i])){
                set.remove(str[start++]);
            }
            set.add(str[i]);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
