// Problem link: https://leetcode.com/problems/shifting-letters-ii/description
// Time: O(n + m)
// Space: O(n)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int total = 0, store[] = new int[s.length()], prefix[] = new int[s.length() + 1];
        StringBuilder result = new StringBuilder();

        for(int index = 0; index < s.length(); index++) {
            store[index] = s.charAt(index) - 'a';
        }

        for(int index = 0; index < shifts.length; index++) {
            prefix[shifts[index][1] + 1] += shifts[index][2] == 1 ? 1 : -1;
            prefix[shifts[index][0]] += shifts[index][2] == 1 ? -1 : 1;
        }

        total = prefix[s.length()];

        for(int index = s.length() - 1; index >= 0; index--) {
            store[index] = (((store[index] + total) % 26) + 26) % 26;
            total += prefix[index];
        }

        for(int val : store) {
            result.append((char)('a' + val));
        }

        return result.toString();
    }
}
