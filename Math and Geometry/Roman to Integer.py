# Problem link: https://leetcode.com/problems/roman-to-integer/description/
class Solution:
    def romanToInt(self, s: str) -> int:
        roman_numerals = {"M": 1000, "CM": 900, "D": 500, "CD": 400, "C": 100, "XC": 90, "L": 50, "XL": 40,
                            "X": 10, "IX": 9, "V": 5, "IV": 4, "I": 1}
        
        result = idx = 0

        while idx < len(s):
            if idx + 1 < len(s) and s[idx: idx + 2] in roman_numerals:
                result += roman_numerals[s[idx: idx + 2]]
                idx += 2
            else:
                result += roman_numerals[s[idx]]
                idx += 1
        
        return result
