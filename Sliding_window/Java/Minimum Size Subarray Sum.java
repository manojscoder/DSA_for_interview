// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/minimum-size-subarray-sum/description/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min,i - j + 1);
                sum -= nums[j++];
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
