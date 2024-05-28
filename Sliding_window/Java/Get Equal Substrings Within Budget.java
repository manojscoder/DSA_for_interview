// Problem link: https://leetcode.com/problems/get-equal-substrings-within-budget/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0, total = 0, j = 0;

        for(int i = 0; i < s.length(); i++){
            total += (Math.abs(s.charAt(i) - t.charAt(i)));

            while(j <= i && total > maxCost){
                total -= (Math.abs(s.charAt(j) - t.charAt(j)));
                j++;
            }

            result = Math.max(result, i - j + 1);
        }

        return result;
    }
}
