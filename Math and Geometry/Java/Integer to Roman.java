// Problem link: https://leetcode.com/problems/integer-to-roman/description/
class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int idx = 0; idx < values.length; idx++) {
            if((int)(num / values[idx]) > 0) {
                int count = (int)(num / values[idx]);
                while(count > 0) {
                    result.append(symbols[idx]);
                    count -= 1;
                }
                num %= values[idx];
            }
        }

        return result.toString();
    }
}
