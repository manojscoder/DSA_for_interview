// Problem link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Time: O(n * 4 ^ n)
// Space: O(n)
public class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

        String[] store = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        if(n > 0) {
            backtrack(0, digits.toCharArray(), new char[n], result, store);
        }

        return result;
    }

    private void backtrack(int index, char[] digits, char[] curr, List<String> result, String[] store) {
        if(index == digits.length) {
            result.add(new String(curr));
            return;
        }

        int num = digits[index] - '0' - 2;
        for(char c : store[num].toCharArray()) {
            curr[index] = c;
            backtrack(index + 1, digits, curr, result, store);
        }
    }
}
