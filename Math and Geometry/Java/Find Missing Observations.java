// Problem link: https://leetcode.com/problems/find-missing-observations/
// Time: O(n)
//Space: O(1)
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int expected_val = mean * (rolls.length + n), total = 0;

        for(int i : rolls)
            total += i;

        if(total + (n * 6) < expected_val || total + n > expected_val)
            return new int[] {};
        
        int[] result = new int[n];
        int remaining = expected_val - total;
        int balance = remaining % n;

        for(int i = 0; i < n; i++) {
            result[i] = (int)(remaining / n);
            if(balance > 0) {
                result[i] += 1;
                balance--;
            }
        }
        
        return result;
    }
}
