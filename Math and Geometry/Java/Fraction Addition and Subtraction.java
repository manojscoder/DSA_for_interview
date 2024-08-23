// Problem link: https://leetcode.com/problems/fraction-addition-and-subtraction/description
// Time: O(n)
// Space: O(1)
class Solution {
    public String fractionAddition(String expression) {
        int num = 0, den = 1, idx = 0, sign;

        while(idx < expression.length()) {
            sign = 1;
            if(expression.charAt(idx) == '-' || expression.charAt(idx) == '+') {
                sign = expression.charAt(idx) == '-' ? -1 : 1;
                idx++;
            }
            
            int numTemp = 0;
            while(idx < expression.length() && Character.isDigit(expression.charAt(idx))) {
                numTemp = numTemp * 10 + (expression.charAt(idx) - '0');
                idx++;
            }
            
            idx++;
            
            int denTemp = 0;
            while(idx < expression.length() && Character.isDigit(expression.charAt(idx))) {
                denTemp = denTemp * 10 + (expression.charAt(idx) - '0');
                idx++;
            }
            
            num = num * denTemp + sign * numTemp * den;
            den *= denTemp;
        }
        
        int gcd = gcd(Math.abs(num), den);
        num /= gcd;
        den /= gcd;
        
        return num + "/" + deno;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a % b);
    }
}
