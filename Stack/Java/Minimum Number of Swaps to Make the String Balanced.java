// Problem link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int minSwaps(String s) {
        int count = 0, result = 0;

        for(char chr : s.toCharArray()) {
            if(chr == ']') {
                count++;
            }
            else {
                count--;
            }
            result = Math.max(result, count);
        }

        return (int)(result + 1) / 2;
    }
}
