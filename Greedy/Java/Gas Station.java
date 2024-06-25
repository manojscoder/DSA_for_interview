// Problem link: https://leetcode.com/problems/gas-station/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0, total_cost = 0;

        for(int i = 0; i < gas.length; i++) {
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if(total_gas < total_cost)
            return -1;
        
        int total = 0, result = -1;

        for(int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if(total >= 0 && result == -1) {
                result = i;
            }
            else if(total < 0){
                total = 0;
                result = -1;
            }
        }

        return result;
    }
}
