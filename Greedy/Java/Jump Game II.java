// Problem link: https://leetcode.com/problems/jump-game-ii/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0, far;

        while(r < nums.length - 1){
            far = 0;
            for(int i = l; i <= r; i++){
                far = Math.max(far, i + nums[i]);
            }
            l = r + 1;
            r = far;
            res += 1;
        }

        return res;
    }
}
