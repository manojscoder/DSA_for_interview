// Problem link: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('0');

        for(char chr : s.toCharArray()) {
            if(chr == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else if(chr == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else {
                stack.push(chr);
            }
        }

        return stack.size() - 1;
    }
}
