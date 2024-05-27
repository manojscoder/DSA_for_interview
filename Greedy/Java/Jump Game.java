// Problem link: https://leetcode.com/problems/jump-game/description
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
      
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
      
        return goal == 0;
    }
}
