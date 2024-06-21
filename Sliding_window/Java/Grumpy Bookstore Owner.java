// Problem link: https://leetcode.com/problems/grumpy-bookstore-owner/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int prevIdx = 0, result = 0, temp = 0, bonus = 0;

        for(int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0)
                result += customers[i];
            else
                temp += customers[i];
            
            if(i >= minutes - 1) {
                bonus = Math.max(bonus, temp);

                if(grumpy[prevIdx] == 1)
                    temp -= customers[prevIdx]; 
                prevIdx++;
            }
        }

        return Math.max(temp, bonus) + result;
    }
}
