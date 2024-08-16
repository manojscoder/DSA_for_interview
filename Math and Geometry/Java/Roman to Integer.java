// problem link: https://leetcode.com/problems/roman-to-integer/description/
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put("M", 1000);
        romanNumerals.put("CM", 900);
        romanNumerals.put("D", 500);
        romanNumerals.put("CD", 400);
        romanNumerals.put("C", 100);
        romanNumerals.put("XC", 90);
        romanNumerals.put("L", 50);
        romanNumerals.put("XL", 40);
        romanNumerals.put("X", 10);
        romanNumerals.put("IX", 9);
        romanNumerals.put("V", 5);
        romanNumerals.put("IV", 4);
        romanNumerals.put("I", 1);

        int result = 0, idx = 0;

        while(idx < s.length()) {
            if(idx + 1 < s.length() && romanNumerals.containsKey(s.substring(idx, idx + 2))) {
                result += romanNumerals.get(s.substring(idx, idx + 2));
                idx += 2;
            }
            else {
                result += romanNumerals.get(s.substring(idx, idx + 1));
                idx += 1;
            }
        }

        return result;
    }
}
