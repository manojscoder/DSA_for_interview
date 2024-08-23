# Problem link: https://leetcode.com/problems/fraction-addition-and-subtraction/description
# Time: O(n)
# Space: O(1)
class Solution:
    def fractionAddition(self, expression: str) -> str:
        num, den = 0, 1
        idx = 0

        while idx < len(expression):
            sign = 1
            if expression[idx] == '-' or expression[idx] == '+':
                sign = -1 if expression[idx] == '-' else 1
                idx += 1
            
            numTemp = 0
            while idx < len(expression) and expression[idx].isdigit():
                numTemp = numTemp * 10 + int(expression[idx])
                idx += 1
            
            idx += 1
            
            denTemp = 0
            while idx < len(expression) and expression[idx].isdigit():
                denTemp = denTemp * 10 + int(expression[idx])
                idx += 1
            
            num = num * denTemp + sign * numTemp * den
            den *= denTemp
        
        gcd_value = self.gcd(abs(num), den)
        num //= gcd_value
        den //= gcd_value
        
        return f"{num}/{den}"
    
    def gcd(self, a: int, b: int) -> int:
        if b == 0:
            return a
        return self.gcd(b, a % b)
