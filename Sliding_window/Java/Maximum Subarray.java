// Problem link: https://leetcode.com/problems/maximum-subarray/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i:nums){
            if(sum < 0)
                sum = 0;
            sum += i;
            max = Math.max(sum,max);
        }
        return max;
    }
}
