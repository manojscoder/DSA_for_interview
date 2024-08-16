# Problem link: https://leetcode.com/problems/integer-to-roman/description/
class Solution:
    def intToRoman(self, num: int) -> str:
        result = []
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]

        for idx in range(len(values)):
            count = num // values[idx]
            if count > 0:
                result.append(symbols[idx] * count)
                num %= values[idx]

        return ''.join(result)
